package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://st-lab.tistory.com/128 참고..
public class boj_1149 {
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        cost=new int[n][3];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            cost[i][0]=Integer.parseInt(st.nextToken());
            cost[i][1]=Integer.parseInt(st.nextToken());
            cost[i][2]=Integer.parseInt(st.nextToken());
        }

        //red cost[n][0]=min(cost[n-1][1],cost[n-1][2])+cost[n][0]
        //green cost[n][1]=min(cost[n-1][0],cost[n-1][2])+cost[n][1]
        //blue cost[n][2]=min(cost[n-1][1],cost[n-1][0])+cost[n][2]

        for(int i=1;i<n;i++){
            cost[i][0]+=Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1]+=Math.min(cost[i-1][0],cost[i-1][2]);
            cost[i][2]+=Math.min(cost[i-1][0],cost[i-1][1]);
        }
        System.out.println(Math.min(Math.min(cost[n-1][0],cost[n-1][1]),cost[n-1][2]));
    }
}
