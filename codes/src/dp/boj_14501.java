package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] T=new int[N+1];
        int[] P=new int[N+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp=new int[N+1];

        for(int i=0;i<N;i++){
            if(i+T[i]<=N){ //날짜가 범위 안인 경우
                dp[i+T[i]]=Math.max(dp[i]+P[i],dp[i+T[i]]); //오늘 계산 결과 vs 다음날 계산 결과
            }
            dp[i+1]=Math.max(dp[i+1],dp[i]); //다음날의 계산된 값 vs 오늘날 계산된 값
        }
        System.out.println(dp[N]);
    }
}
