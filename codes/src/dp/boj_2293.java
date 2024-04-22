package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2293 {
    //https://mygumi.tistory.com/129 를 참고함.
    static int n,k;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[n+1];
        dp=new int[k+1];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        dp[0]=1; //현재 탐색하는 동전이 동전 그 값일때 경우의 수를 더해주기 위함
        for(int i=0;i<n;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j]=dp[j]+dp[j-arr[i]];
            }
        }
        System.out.println(dp[k]);


    }
}
