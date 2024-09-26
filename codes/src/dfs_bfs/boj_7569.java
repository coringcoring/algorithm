package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {
    private static class Node{
        int z;
        int x;
        int y;
        public Node(int z,int x, int y){
            this.z=z;
            this.x=x;
            this.y=y;
        }
    }
    static int M,N,H;
    static int[][][] arr;
    //왼쪽, 위쪽, 오른쪽, 아래쪽, 높이 위, 높이 아래
    static int[] dx={-1,0,1,0,0,0};
    static int[] dy={0,1,0,-1,0,0};
    static int[] dz={0,0,0,0,1,-1};
    static int[][][] count;
    static Queue<Node> q=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        arr=new int[H][N][M];
        count=new int[H][N][M];

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    arr[i][j][k]=Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1){
                        q.add(new Node(i,j,k));
                    }
                }
            }
        }

        //bfs
        while(!q.isEmpty()){
            Node cur=q.poll();

            int z=cur.z;
            int x=cur.x;
            int y=cur.y;

            for(int i=0;i<6;i++){
                int nz=z+dz[i];
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nz<0 || nz>=H || nx<0 || nx>=N || ny<0 || ny>=M || arr[nz][nx][ny]==-1) continue;
                if(arr[nz][nx][ny]==0){
                    arr[nz][nx][ny]=1;
                    count[nz][nx][ny]=count[z][x][y]+1;
                    q.add(new Node(nz,nx,ny));
                }
            }
        }

        int res=result();
        System.out.println(res);

    }

    private static int result(){
        int result=Integer.MIN_VALUE;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(arr[i][j][k]==0) return -1;
                    result=Math.max(result,count[i][j][k]);
                }
            }
        }
        return result;
    }
}
