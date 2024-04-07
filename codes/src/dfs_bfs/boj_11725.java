package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11725 {
    static int n;
    static int[] parent;
    static ArrayList<Integer> arr[];
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        parent=new int[n+1];
        arr=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=new ArrayList<>();
        }
        visit=new boolean[n+1];

        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1);

        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int level){
        visit[level]=true;
        for(int i: arr[level]){
            if(!visit[i]){
                parent[i]=level;
                dfs(i);
            }
        }
    }
}
