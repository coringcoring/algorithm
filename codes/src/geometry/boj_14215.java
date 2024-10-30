package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[3];
        arr[0]=Integer.parseInt(st.nextToken());
        arr[1]=Integer.parseInt(st.nextToken());
        arr[2]=Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int result;
        if(arr[0]+arr[1]<=arr[2]){
            result=arr[0]+arr[1]+(arr[0]+arr[1]-1);
        }else{
            result=arr[0]+arr[1]+arr[2];
        }
        System.out.println(result);
    }
}
