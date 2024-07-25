package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11582 {
    static int[] arr;
    static int N,K;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        K=Integer.parseInt(br.readLine());

        solve(0,N,N/K);

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
    private static void solve(int start,int end,int size){
        if (end - start <= size) {
            Arrays.sort(arr, start, end);
            return;
        }

        int mid = (start + end) / 2;
        solve(start, mid, size);
        solve(mid, end, size);

        if (end - start <= N/ K) {
            merge(start, mid, end);
        }
    }

    private static void merge(int start,int mid,int end){
        int[] temp = new int[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j < end) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, start, temp.length);
    }
}
