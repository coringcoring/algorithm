package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int avg=(int)Math.round(n*0.15); //2

        int[] arr=new int[n];
        double result=0;

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=avg;i<n-avg;i++){//2~8
            result+=arr[i];
        }

        System.out.println((int)Math.round(result/(n-avg*2)));
    }
}
