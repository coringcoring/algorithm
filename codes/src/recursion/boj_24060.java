package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_24060 {
    static int N,K;
    static int[] arr;
    static int[] tmp;
    static int count=0;
    static int res=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N+1];
        tmp=new int[N+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        merge_sort(arr,0,N-1);
        System.out.println(res);
    }
    static void merge_sort(int a[],int p, int r){
        if(count > K) return;
        if(p < r){
            int q = (p+r)/2;
            merge_sort(a, p, q);   //전반부 정렬
            merge_sort(a,q+1, r); //후반부 정렬
            merge(a, p, q, r); //병합
        }
    }

    static void merge(int a[],int p, int q, int r){
        int i = p;
        int j = q + 1;
        int t = 0;


        while(i <= q && j <= r){
            if(a[i] < a[j]){
                tmp[t++] = a[i++];
            }
            else{
                tmp[t++] = a[j++];
            }
        }

        while(i <= q){
            tmp[t++] = a[i++];
        }

        while(j <= r){
            tmp[t++] = a[j++];
        }

        i = p;
        t = 0;
        while(i <= r){
            count++;

            if(count == K){
                res = tmp[t];
                break;
            }

            a[i++] = tmp[t++];
        }
    }
}
