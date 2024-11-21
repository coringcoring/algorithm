package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고: https://st-lab.tistory.com/285
public class boj_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[] arr=new int[N];
        int[] lis=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        lis[0]=arr[0];
        int len=1;

        for(int i=1;i<N;i++){
            int key=arr[i];

            if(lis[len-1]<key){
                len++;
                lis[len-1]=key;
            }else{
                int low=0;
                int high=len;
                while(low<high){
                    int mid=(low+high)/2;
                    if(lis[mid]<key) low=mid+1;
                    else high=mid;
                }
                lis[low]=key;
            }
        }

        System.out.println(len);
    }
}
