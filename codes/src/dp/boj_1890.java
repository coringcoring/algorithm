package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] map=new int[N][N];
        long[][] dp=new long[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //dp 초기화
        dp[0][0]=1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int nxt=map[i][j];
                //종착지
                if(nxt==0) break;

                //아래로
                if(j+nxt<N){
                    dp[i][j+nxt]+=dp[i][j];
                }
                //오른쪽으로
                if(i+nxt<N){
                    dp[i+nxt][j]+=dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
