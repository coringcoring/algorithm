package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13913 {
    static int N,K;
    static boolean[] visit=new boolean[100001];
    static int[] count=new int[100001];
    static int[] parent=new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        if(N==K){
            System.out.println(0);
            System.out.println(N);
        }else{
            bfs(N);
            System.out.println(count[K]-1);

            Stack<Integer> stack=new Stack<>();
            stack.add(K);
            int idx=K;
            while(idx!=N){
                stack.push(parent[idx]);
                idx=parent[idx];
            }
            StringBuilder sb=new StringBuilder();

            while(!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb);

        }
    }

    private static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        count[start]=1;

        while(!q.isEmpty()){
            int cur=q.poll();

            if(cur==K) return;

            if(cur*2<=100000 && count[cur*2]==0){
                count[cur*2]=count[cur]+1;
                parent[cur*2]=cur;
                q.add(cur*2);
            }
            if(cur+1<=100000 && count[cur+1]==0){
                count[cur+1]=count[cur]+1;
                parent[cur+1]=cur;
                q.add(cur+1);
            }
            if(cur-1>=0 && count[cur-1]==0){
                count[cur-1]=count[cur]+1;
                parent[cur-1]=cur;
                q.add(cur-1);
            }
        }
    }
}
