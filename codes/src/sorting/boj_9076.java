package sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class boj_9076 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        int[] arr=new int[5];
        int[] res=new int[t];

        for(int i=0;i<t;i++){
            for(int j=0;j<5;j++){
                arr[j]=sc.nextInt();
            }
            Arrays.sort(arr);
            if(arr[3]-arr[1]>=4) res[i]=-1;
            else res[i]=arr[1]+arr[2]+arr[3];
        }

        for(int i=0;i<t;i++){
            if(res[i]==-1) System.out.println("KIN");
            else System.out.println(res[i]);
        }
    }
}
