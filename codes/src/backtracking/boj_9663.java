package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9663 {
    static int n;
    static int[] arr;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        queen(0);
        System.out.println(count);
    }

    public static void queen(int depth){
        if(depth==n){
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            arr[depth]=i;
            if(possible(depth)){
                queen(depth+1);
            }
        }
    }

    public static boolean possible(int depth){
        for(int i=0;i<depth;i++){
            if(arr[depth]==arr[i]){
                return false;
            }
            else if(Math.abs(depth-i)==Math.abs(arr[depth]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
