package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[][] arr=new int[n+1][n+1];
        int[][] dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
            }
        }

        int result=0;
        for(int i=1;i<=n;i++){
            result=Math.max(result,dp[n][i]);
        }
        System.out.println(result);
    }
}
