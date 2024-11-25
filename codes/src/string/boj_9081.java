package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_9081 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        while(T-->0){
            char[] arr=br.readLine().toCharArray();
            solve(arr);
        }

        System.out.println(sb.toString());
    }

    private static void solve(char[] arr){
        int size=arr.length;
        int swap1=-1;
        int swap2=0;

        //뒤에서부터 감소하는 부분 찾기
        for(int i=size-1;i>0;i--){
            if(arr[i-1]<arr[i]){
                swap1=i-1;
                break;
            }
        }

        if(swap1==-1){
            sb.append(arr).append("\n");
            return;
        }

        //뒤에서부터 swap1보다 큰 수 찾기
        for(int i=size-1;i>=0;i--){
            if(arr[swap1]<arr[i]){
                swap2=i;
                break;
            }
        }

        char tmp=arr[swap1];
        arr[swap1]=arr[swap2];
        arr[swap2]=tmp;

        Arrays.sort(arr,swap1+1,size);
        for(char c: arr){
            sb.append(c);
        }
        sb.append("\n");
    }
}
