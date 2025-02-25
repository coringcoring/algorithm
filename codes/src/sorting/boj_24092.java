package sorting;

import java.io.*;
import java.util.StringTokenizer;

public class boj_24092 {
    static int check=0;
    static long[] a;
    static long[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        a=new long[n];
        b=new long[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Long.parseLong(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            b[i]=Long.parseLong(st.nextToken());
        }
        isSame();
        if(check!=-1){
            quick_sort(a,0,n-1);
        }

        System.out.println(check==-1? 1:0);
        br.close();
    }

    private static void quick_sort(long[] arr,int left,int right){
        if(left<right){
            int q=partition(arr,left,right);
            quick_sort(arr,left,q-1);
            quick_sort(arr,q+1,right);
        }
    }

    private static int partition(long[] arr,int left,int right){
        long x=arr[right];
        int i=left-1;

        for(int j=left;j<right;j++){
            if(arr[j]<=x){
                i++;
                long temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                //배열의 변경이 check(이전에 비교했을때 달랐던 인덱스 위치)와 같은 인덱스에서 일어났다면
                //배열을 다시 비교해야함
                if(check==i || check==j){
                    isSame();
                }
            }
        }
        if(i+1!=right){
            long temp=arr[i+1];
            arr[i+1]=arr[right];
            arr[right]=temp;

            if(check==i+1 || check==right){
                isSame();
            }
        }

        return i+1;
    }

    private static void isSame(){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                check=i;
                return;
            }
        }
        check=-1;
    }
}
