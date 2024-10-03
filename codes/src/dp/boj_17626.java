package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//참고: https://steady-coding.tistory.com/18
public class boj_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp=new int[N+1];
        dp[1]=1;

        int min=0;
        for(int i=2;i<=N;i++){
            min=Integer.MAX_VALUE;

            for(int j=1;j*j<=i;j++){
                int tmp=i-j*j;
                min=Math.min(min,dp[tmp]);
            }
            dp[i]=min+1;
        }
        System.out.println(dp[N]);

    }
}
