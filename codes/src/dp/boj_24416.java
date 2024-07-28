package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_24416 {
    static int count1=0;
    static int count2=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        fib(n);
        fib2(n);

        System.out.println(count1+" "+count2);
    }
    //1 1 2 3 5
    private static int fib(int n){
        if(n==1 || n==2){
            count1++;
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
    private static int fib2(int n){
        count2++;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<n;i++){
            count2++;
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
