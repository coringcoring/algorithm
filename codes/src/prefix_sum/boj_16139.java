package prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class boj_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s=br.readLine().toCharArray();

        int[][] dp=new int[s.length+1][26];
        for(int i=1;i<=s.length;i++){
            int cur=s[i-1]-'a';
            for(int j=0;j<26;j++){
                if(cur==j){
                    dp[i][j]=dp[i-1][j]+1;
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        int q=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i=0;i<q;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=st.nextToken().charAt(0)-'a';
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());

            sb.append(dp[r+1][a]-dp[l][a]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
