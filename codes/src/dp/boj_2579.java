package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2579 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int[] dp=new int[n+1];
        dp[1]=arr[1];
        //bottom up
        if(n>=2){ //n이 1인 경우도 있음. n이 2 이상인 경우 따로 전처리
            dp[2]=arr[1]+arr[2];
        }
        for (int i=3;i<=n;i++){
            dp[i]=Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i];
        }
        System.out.println(dp[n]);
    }
}
