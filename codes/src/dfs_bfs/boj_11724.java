package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11724 {
    static ArrayList<Integer> arr[];
    static boolean[] visit;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        arr=new ArrayList[n+1];
        visit=new boolean[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            StringTokenizer st2=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st2.nextToken());
            int b=Integer.parseInt(st2.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=1;i<=n;i++){
            if(!visit[i]){
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }
    public static void dfs(int level){
        visit[level]=true;
        for(int i:arr[level]){
            if(!visit[i]){
                dfs(i);
            }
        }
    }
}
