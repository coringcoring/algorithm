package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549 {
    static int N,K;
//    static int min=Integer.MAX_VALUE;
    static boolean[] visit=new boolean[100001];
    static int[] count=new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        Arrays.fill(count,100001);

        if(N==K){
            System.out.println(0);
        }else{
            bfs(N);
        }
    }

    private static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        count[start]=0;

        while(!q.isEmpty()){
            int cur=q.poll();
            visit[cur]=true;

            if(cur==K){
                System.out.println(count[cur]);
                return;
            }

            for(int i=0;i<3;i++){
                int nxt;
                if(i==0){
                    nxt=cur*2;
                }else if(i==1){
                    nxt=cur+1;
                }else{
                    nxt=cur-1;
                }

                if(nxt>=0 && nxt<visit.length && !visit[nxt]){
                    q.add(nxt);
                    if(nxt!=cur*2){
                        count[nxt]=Math.min(count[cur]+1,count[nxt]);
                    }else{
                        count[nxt]=Math.min(count[cur],count[nxt]);
                    }
                }

            }
        }
    }
}
