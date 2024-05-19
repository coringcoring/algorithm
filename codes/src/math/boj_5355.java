package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++){
            String line=br.readLine();
            String[] arr=line.split(" ");
            float num=Float.parseFloat(arr[0]);
            for(int j=1;j<arr.length;j++){
                if(arr[j].equals("@")) num*=3;
                else if(arr[j].equals("%")) num+=5;
                else if(arr[j].equals("#")) num-=7;
            }
            System.out.println(String.format("%.2f",num));
        }
    }
}
