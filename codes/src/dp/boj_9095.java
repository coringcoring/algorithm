package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int[] dp=new int[11];
        dp[1]=1;
        dp[2]=2; //1+1, 2
        dp[3]=4;  //1+1+1, 1+2, 3, 2+1

        for(int i=4;i<=10;i++){
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }
        for(int i=0;i<T;i++){
            int n=Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}