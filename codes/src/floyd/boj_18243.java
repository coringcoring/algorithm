package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_18243 {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        int[][] arr=new int[N+1][N+1];
        for(int i=0;i<N+1;i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE/2);
        }
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=1;
            arr[b][a]=1;
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                for(int k=1;k<N+1;k++){
                    arr[j][k]=Math.min(arr[j][i]+arr[i][k],arr[j][k]);
                }
            }
        }
        result(arr);
    }
    public static void result(int arr[][]){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if((arr[i][j]==Integer.MAX_VALUE/2 && i!=j) || arr[i][j]>6){
                    System.out.println("Big World!");
                    return;
                }
            }
        }
        System.out.println("Small World!");
    }
}
