package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        char[] arr=br.readLine().toCharArray();
        int[] dp=new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE);
        //시작점 초기화
        dp[0]=0;

        //N이 1000이하므로 이중 반복문 가능하다고 판단
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                //B->O (오버플로우 막기 위해 탐색하지 않았던 인덱스 위치는 계산에 넣으면 안됨)
                //dp[j]가 max value == 탐색하지 않았다 == boj 순서를 지키지 못해 탐색하지 못한 것임
                if(arr[i]=='O' && arr[j]=='B' && dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[j]+(i-j)*(i-j));
                }
                //O->J
                else if(arr[i]=='J' && arr[j]=='O' && dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[j]+(i-j)*(i-j));
                }
                //J->B
                else if(arr[j]=='J' && arr[i]=='B' && dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[j]+(i-j)*(i-j));
                }
            }
        }

        if(dp[N-1]==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[N-1]);
        }
    }
}
