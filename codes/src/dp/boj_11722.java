package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11722 {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new int[n];
        dp=new Integer[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++){
            recursion(i);
        }
        int max=dp[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }

    public static int recursion(int n){
        if(dp[n]==null){//n번째 이전에 탐색한 결과물이 있는지 판단
            dp[n]=1;//없었다면 1로 초기화

            for(int i=n-1;i>=0;i--){//n-1부터 0까지 탐색 1
                if(arr[i]>arr[n]){//현재 노드의 값(n번째 값)보다 큰 노드를 탐색
                    dp[n]=Math.max(dp[n],recursion(i)+1);//+1 한 이유: n번째 원소 추가
                }
            }
        }
        return dp[n];
    }
}
