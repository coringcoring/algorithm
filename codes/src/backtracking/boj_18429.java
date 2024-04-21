package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18429 {
    static int N;
    static int K;
    static int[] arr;
    static boolean[] visit;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N];
        visit=new boolean[N];
        StringTokenizer st2=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st2.nextToken())-K;
        }
        dfs(0,500);
        System.out.println(result);
    }
    public static void dfs(int level,int weight){
        if(level==N){
            result++;
            return;
        }
        for(int i=0;i<N;i++){
            if(!visit[i] && weight+arr[i]>=500){
                visit[i]=true;
                dfs(level+1,weight+arr[i]);
                visit[i]=false;
            }
        }
    }
}
