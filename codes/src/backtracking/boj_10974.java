package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10974 {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        arr=new int[N];
        visited=new boolean[N];

        dfs(0);
    }

    private static void dfs(int depth){
        if(depth==N){
            for(int i=0;i<N;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth]=i+1;
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }
}
