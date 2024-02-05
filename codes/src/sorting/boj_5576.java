package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_5576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] w=new int[10];
        int[] k=new int[10];

        for(int i=0;i<10;i++){
            w[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<10;i++){
            k[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(w);
        Arrays.sort(k);

        System.out.print(w[9]+w[8]+w[7]+" ");
        System.out.print(k[9]+k[8]+k[7]);

    }
}
