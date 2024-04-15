package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] dp=new int[n+1][3];
        dp[1][0] = 1;  // 아무칸에두 사자를 두지 않는 경우
        dp[1][1] = 1;  // 왼쪽칸에 사자를 두는 경우
        dp[1][2] = 1;  // 오른쪽칸에 사자를 두는 경우

        int result=0;
        //dp[n][0]=>dp[n-1][0],dp[n][1]에 없어야함, dp[n-1][1]에는 있어도 됨
        //dp[n][1]=>dp[n-1][1],dp[n][0]에 없어야함 dp[n-1][0]에는 있어도됨

        for(int i=2;i<=n;i++){
            //i번째에 사자 암것도 안두는 경우
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            //i번째 왼쪽에 사자 두는 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            //i번째 오른쪽에 사자 두는 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }
}
