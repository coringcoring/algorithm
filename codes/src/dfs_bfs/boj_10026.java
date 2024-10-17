package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {
    static int N;
    static char[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i=0;i<N;i++){
            String s= br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j);
            }
        }
        visit=new boolean[N][N];
        int answer1=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j,arr[i][j]);
                    answer1++;
                }
                //다음 반복문에서 적록색맹 탐색을 위해 색을 바꾸어줌
                if(arr[i][j]=='G'){
                    arr[i][j]='R';
                }
            }
        }

        visit=new boolean[N][N];
        int answer2=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j,arr[i][j]);
                    answer2++;
                }
            }
        }
        System.out.println(answer1+" "+answer2);

    }
    private static void bfs(int x,int y,char target){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visit[x][y]=true;

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int curx=cur[0],cury=cur[1];
            for(int i=0;i<4;i++){
                int nx=curx+dx[i];
                int ny=cury+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N || visit[nx][ny]) continue;
                if(!visit[nx][ny] && arr[nx][ny]==target){
                    visit[nx][ny]=true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}
