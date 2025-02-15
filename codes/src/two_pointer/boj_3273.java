package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int x=Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int low=0;
        int high=n-1;
        int count=0;

        while(low<high){
            int sum=arr[low]+arr[high];

            if(sum==x) {
                count++;
            }

            if(sum>x){
                high--;
            }else{
                low++;
            }
        }

        System.out.println(count);
    }
}
