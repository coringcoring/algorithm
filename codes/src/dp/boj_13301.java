package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] dp=new long[81];

        dp[1]=4;
        dp[2]=6;
        for(int i=3;i<=N;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
