package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고: https://st-lab.tistory.com/141
//짐을 쪼갤 수 없기 때문에-> 그리디가 아니라 DP로 해결해야하는 배낭 문제
public class boj_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] w=new int[N+1];
        int[] v=new int[N+1];
        int[][] dp=new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            w[i]=Integer.parseInt(st.nextToken());
            v[i]=Integer.parseInt(st.nextToken());
        }

        int max=-1;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                //i번째 무게를 더 담을 수 없는 경우
                if(w[i]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{//담을 수 있는 경우
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }

        System.out.println(dp[N][K]);


    }
}
