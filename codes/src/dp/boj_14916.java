package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14916 {
    //https://propercoding.tistory.com/62 참고
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] dp=new int[100001];
        //dp 초기화
        dp[1]=-1; //1원을 만들 수 있는 최소 동전 개수: 없음
        dp[2]=1; //2원을 만들 수 있는 최소 동전 개수: 2원 1개
        dp[3]=-1; //3원을 만들 수 있는 최소 동전 개수: 없음
        dp[4]=2; //4원을 만들 수 있는 최소 동전 개수: 2원 2개
        dp[5]=1; //5원을 만들 수 있는 최소 동전 개수: 5원 1개

        for(int i=6;i<=N;i++){
            //최소값을 업데이트해주어야하므로 MAX VALUE로 초기화
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=6;i<=N;i++){
            if(dp[i-2]==-1 && dp[i-5]==-1){
                dp[i]=-1;
            }
            else if(dp[i-2]==-1){
                dp[i]=dp[i-5]+1;
            }
            else if(dp[i-5]==-1){
                dp[i]=dp[i-2]+1;
            }
            else{
                dp[i]=Math.min(dp[i-2],dp[i-5])+1;
            }
        }

        System.out.println(dp[N]);
    }
}
