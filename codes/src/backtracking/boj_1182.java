package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182 {
    static int n;
    static int s;
    static int[] arr;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st1.nextToken());
        s=Integer.parseInt(st1.nextToken());

        arr=new int[n];
        StringTokenizer st2=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }

        dfs(0,0);
        if(s==0){//sum을 0으로 초기화 두었으므로 1가지 빼주어야함
            result--;
        }
        System.out.println(result);
    }

    public static void dfs(int level,int sum){
        if (level==n){
            if(sum==s){
                result++;
            }
            return;
        }
        dfs(level+1,sum+arr[level]); //선택
        dfs(level+1,sum); //선택 안함
    }
}
