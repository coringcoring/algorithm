package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2776 {
    static int[] arr;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            N = Integer.parseInt(br.readLine());
            arr=new int[N];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            M=Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                int k=Integer.parseInt(st.nextToken());

                int res=search(k);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static int search(int k){
        int low=0;
        int high=N-1;

        while(low<=high) {
            int mid = (low + high) / 2;

            if (arr[mid] > k) {
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            }
            if (arr[mid] == k) {
                return 1;
            }
        }
        return 0;
    }
}
