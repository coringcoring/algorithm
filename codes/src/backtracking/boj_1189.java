package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1189 {
    static int R,C,K;
    static int result=0;
    static char[][] graph;
    static boolean[][] visit;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        graph=new char[R][C];
        visit=new boolean[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                graph[i][j]=s.charAt(j);
            }
        }

        visit[R-1][0]=true;
        solve(R-1,0,1);

        System.out.println(result);

    }

    private static void solve(int x, int y,int k){
        if(x==0 && y==C-1){
            if(K==k) result++;
            else return;
        }
        else{
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx>=0 && ny>=0 && nx<R && ny<C && graph[nx][ny]=='.' && graph[nx][ny]!='T' && !visit[nx][ny]){
                    visit[nx][ny]=true;
                    solve(nx,ny,k+1);
                    visit[nx][ny]=false;
                }

            }
        }
    }
}
