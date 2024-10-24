package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고: https://hanyeop.tistory.com/416
public class boj_14500 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int result=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
                visit[i][j]=true;
                solve(i,j,arr[i][j],1);
                visit[i][j]=false;
            }
        }

        System.out.println(result);

    }

    private static void solve(int x,int y,int sum,int count){
        if(count==4){
            result=Math.max(result,sum);
            return;
        }

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            if(!visit[nx][ny]){
                //ㅗ모양 만들기 위해서 탐색 한번더 진행
                if(count==2){
                    visit[nx][ny]=true;
                    solve(x,y,sum+arr[nx][ny],count+1);
                }
                visit[nx][ny]=true;
                solve(nx,ny,sum+arr[nx][ny],count+1);
                visit[nx][ny]=false;
            }
        }
    }
}
