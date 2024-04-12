package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1010 {
    //https://st-lab.tistory.com/194 를 참고
    //조합론!
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        int[][] dp=new int[30][30];

        for(int i=0;i<30;i++){
            dp[i][i]=1;
            dp[i][0]=1;
        }

        for(int i=2;i<30;i++){
            for(int j=1;j<30;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }

        for(int i=0;i<t;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            sb.append(dp[m][n]).append("\n");
        }

        System.out.println(sb);
    }
}
