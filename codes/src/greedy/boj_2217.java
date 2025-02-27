package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Integer[] rope=new Integer[n];

        int weight=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            rope[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());

        for(int i=0;i<n;i++){
            if(rope[i]*(i+1)>weight){
                weight=rope[i]*(i+1);
            }
        }

        System.out.println(weight);
    }
}
