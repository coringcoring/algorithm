package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        int result=0;

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        for(int i=n-1;i>=0;i--){
            if(arr[i]<=k){
                result+=k/arr[i]; //몫
                k=k%arr[i]; //남은 k (나머지)
            }
        }

        System.out.println(result);

    }
}
