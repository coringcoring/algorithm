package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2468 {
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,-1,0,1};
    static int max_h=100; //지역의 최대 높이
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int a=Integer.parseInt(st.nextToken());
                if(a>max_h) max_h=a;
                arr[i][j]=a;
            }
        }

        int max_result=0;
        for(int i=0;i<=max_h;i++){
            int count=0;
            visit=new boolean[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(arr[j][k]>i && !visit[j][k]){
                        count++;
                        dfs(j,k,i);
                    }
                }
            }
            max_result=Math.max(count,max_result);
        }
        System.out.println(max_result);
    }

    public static void dfs(int x,int y,int height){
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=0&&ny>=0&&nx<N&&ny<N && arr[nx][ny]>height && !visit[nx][ny]){
                dfs(nx,ny,height);
            }
        }
    }
}
