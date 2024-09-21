package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] count;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());


        arr=new int[N][M];
        visit=new boolean[N][M];
        count=new int[N][M];


        //bfs용
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }

        //bfs
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || arr[nx][ny]==-1) continue;
                if(arr[nx][ny]==0){
                    arr[nx][ny]=1;
                    count[nx][ny]=count[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        int result=res();

        System.out.println(result);
    }

    private static int res(){
        int result=-1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    result=-1;
                    return -1;
                }
                result=Math.max(result,count[i][j]);
            }
        }
        return result;
    }
}
