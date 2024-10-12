package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_21736 {
    static int N,M;
    static boolean[][] visit;
    static char[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=s.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]=='I'){
                    bfs(i,j);
                    break;
                }
            }
        }
        if(count==0){
            System.out.println("TT");
        }else{
            System.out.println(count);
        }
        br.close();
    }
    private static void bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int curx=cur[0];
            int cury=cur[1];

            for(int i=0;i<4;i++){
                int nx=curx+dx[i];
                int ny=cury+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(!visit[nx][ny] && arr[nx][ny]!='X'){
                    if(arr[nx][ny]=='P') count++;
                    visit[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}
