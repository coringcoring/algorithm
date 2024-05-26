package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] arr=new long[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());

        long sum=0;
        arr[0]=Long.parseLong(st.nextToken());
        for(int i=1;i<N;i++){
            long n=Long.parseLong(st.nextToken());
            arr[i]=n+arr[i-1];
            sum+=arr[i-1]*n;
        }

        System.out.println(sum);
    }
}
