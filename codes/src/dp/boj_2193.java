package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] dp=new long[91];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        //1: 1
        //2: 10
        //3: 100,101,
        //4: 1000,1001,1010
        //5: 10000,10001,10010,10100,10101
        for(int i=3;i<=N;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        System.out.println(dp[N]);

    }
}
