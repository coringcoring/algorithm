package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {
    static int N,M;
    static int[][] graph;
    static boolean[][] visit;
    static int[][] count;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        graph=new int[N][M];
        visit=new boolean[N][M];
        count=new int[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                graph[i][j]=s.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(count[N-1][M-1]);
    }
    private static void bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {x,y});
        visit[x][y]=true;
        count[x][y]=1;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny] && graph[nx][ny]==1){
                    q.add(new int[] {nx,ny});
                    visit[nx][ny]=true;
                    count[nx][ny]=count[cur[0]][cur[1]]+1;
                }
            }
        }

    }
}
