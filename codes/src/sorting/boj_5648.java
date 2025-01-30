package sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class boj_5648 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        String[] s=new String[n];
        Long[] arr=new Long[n];

        for(int i=0;i<n;i++){
            s[i]=""+sc.nextLong();
        }

        for(int i=0;i<n;i++){
            String temp=s[i];
            s[i]="";
            for(int j=temp.length()-1;j>=0;j--){
                s[i]+=temp.charAt(j)-'0';
            }
            arr[i]=Long.parseLong(s[i]);
        }

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }
}
