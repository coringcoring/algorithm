package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고: https://zzino.tistory.com/7

public class boj_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] dp=new int[N+1];
        int[] l=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            l[i]=Integer.parseInt(st.nextToken());
        }

        dp[1]=l[1];
        for(int i=1;i<=N;i++){
            dp[i]=l[i];
            for(int j=1;j<i;j++){
                if (l[i] > l[j]) {
                    dp[i] = Math.max(dp[j] + l[i], dp[i]);
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i:dp){
            max=Math.max(max,i);
        }
        System.out.println(max);
    }
}
