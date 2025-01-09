package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[] dp=new int[N+1];

        for(int i=1;i<=N;i++){
            dp[i]=i; //1^2로만 이루어진 경우 => 최댓값 경우수로 초기화
            for(int j=1;j*j<=i;j++){
                //제곱수(j*j)는 최솟값이 무조건 1개 이므로
                //i-j*j의 dp 저장값에서 +1 만 하면 됨
                if(dp[i-j*j]+1<dp[i]){
                    dp[i]=dp[i-j*j]+1;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
