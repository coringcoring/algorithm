package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] arr=new int[3];

        String[] s=br.readLine().split(" ");
        arr[0]=Integer.parseInt(s[0]);
        arr[1]=Integer.parseInt(s[1]);
        arr[2]=Integer.parseInt(s[2]);

        Arrays.sort(arr);

        System.out.println(arr[1]);

    }
}
