package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visit;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N+1][M+1];
        visit=new boolean[N+1][M+1];
        result=new int[N+1][M+1];

        //목표 지점 x,y 좌표 저장
        int x=0;
        int y=0;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    x=i;
                    y=j;
                }else if(arr[i][j]==0){
                    //갈수 없는 곳이라면 방문처리를 함
                    visit[i][j]=true;
                }
            }
        }
        bfs(x,y);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visit[i][j]){//방문을 안한 곳이다 == 원래 갈 수 있는 땅 중에 도달할 수 없는 위치
                    result[i][j]=-1;
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y}); //목표지점에서부터 출발
        visit[x][y]=true;

        int[] dx={1,-1,0,0}; //오른쪽, 왼쪽, 상, 하 방향
        int[] dy={0,0,1,-1};

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(!visit[nx][ny] && arr[nx][ny]==1){
                        visit[nx][ny]=true;
                        result[nx][ny]=result[cur[0]][cur[1]]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
