package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class boj_6986 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int k=sc.nextInt();
        double[] arr=new double[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextDouble();
        }

        Arrays.sort(arr);

        //절사평균
        double res1=0.0;
        for(int i=k;i<n-k;i++)
            res1+=arr[i];

        //보정평균
        double res2=0.0;
        for(int i=0;i<n;i++){
            if(i<k) res2+=arr[k];
            else if(i>=n-k) res2+=arr[n-k-1];
            else res2+=arr[i];
        }

        System.out.println(String.format("%.2f",res1/(n-k*2)+1e-8));
        System.out.println(String.format("%.2f",res2/n+1e-8));

    }
}
