package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1926 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int count=0; //그림 수
    static int result=0; //가장 넓은 그림 넓이
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visit=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1 && !visit[i][j]){
                    result=Math.max(bfs(i,j),result);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(result);

        br.close();

    }

    private static int bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y]=true;
        int size=1;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<4;i++){
                int nx=dx[i]+cur[0];
                int ny=dy[i]+cur[1];

                if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny] && arr[nx][ny]==1){
                    q.add(new int[]{nx,ny});
                    visit[nx][ny]=true;
                    size++;
                }
            }
        }
        return size;
    }
}
