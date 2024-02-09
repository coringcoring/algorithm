package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);

        int[][] arr=new int[n][3];
        int[][][] res=new int[n][4][1];

        for(int i=0;i<n;i++){
            String[] input=br.readLine().split(" ");
            for(int j=1;j<4;j++){
                arr[i][j]=Integer.parseInt(input[j]);
            }
        }
//        Arrays.sort(arr,(a,b,c)->{
//            if(a[0])
//        });

    }
}
