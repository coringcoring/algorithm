package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제가 이해가 안되었었음 -> 완벽한 게임이라는 것은 상근이가 먼저 시작했으므로, 상근이가 이기도록 진행하는 것이 완벽한 게임이라는 의미
// 참고: https://j3sung.tistory.com/896
public class boj_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[1001];

        dp[1]=1;
        dp[2]=0;
        dp[3]=1;
        dp[4]=1;

        for(int i=5;i<=n;i++){
            if(dp[i-1]==1 && dp[i-3]==1 && dp[i-4]==1){
                dp[i]=0;
            }else{
                dp[i]=1;
            }
        }

        System.out.println(dp[n]==1? "SK":"CY");
    }
}
