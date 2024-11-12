package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int low=0;
        int high=n-1;
        int chk=Integer.MAX_VALUE;
        int ans1=0;
        int ans2=0;

        while(low<high){
            int sum=arr[low]+arr[high];

            if(Math.abs(sum)<chk){
                chk=Math.abs(sum);
                ans1=arr[low];
                ans2=arr[high];
            }

            if(sum<0){
                low++;
            }else{
                high--;
            }
        }
        System.out.println(ans1+" "+ans2);
    }
}
