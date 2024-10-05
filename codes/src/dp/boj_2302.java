package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[41];

        dp[0]=1;
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=N;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        int result=1;
        int before=0;
        for(int i=0;i<M;i++){
            int tmp=Integer.parseInt(br.readLine());
            result*=dp[tmp-1-before];
            before=tmp;
        }

        result*=dp[N-before];
        System.out.println(result);
    }
}
