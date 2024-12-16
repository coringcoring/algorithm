package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고: https://propercoding.tistory.com/29

public class boj_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] dp=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                dp[i][j]=dp[i][j-1]+Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int sum=0;

            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            for(int k=x1;k<=x2;k++){
                sum+=dp[k][y2]-dp[k][y1-1];
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
