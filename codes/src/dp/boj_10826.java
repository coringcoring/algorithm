package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //dp[n]=dp[n-1]+dp[n-2]

        //숫자가 매우 커서 long으로는 부족 -> BigInteger을 사용해야함
        BigInteger[] dp=new BigInteger[n+2];
        dp[0]=new BigInteger("0");
        dp[1]=new BigInteger("1");

        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-2].add(dp[i-1]);
        }
        System.out.println(dp[n]);
    }
}
