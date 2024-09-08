package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12851 {
    static int N,K;
    static int[] count=new int[100001];
    static boolean[] visit=new boolean[100001];
    static int time;
    static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        if(N==K){
            System.out.println(0);
            System.out.println(1);
        }else{
            bfs(N);
            System.out.println(time);
            System.out.println(ans);
        }

    }

    private static void bfs(int start){
        time=Integer.MAX_VALUE/16;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        count[start]=1;

        while(!q.isEmpty()){
            int cur=q.poll();
            visit[cur]=true;

            if(time<count[cur]){
                return;
            }

            for(int i=0;i<3;i++){
                int nxt;
                if(i==0){
                    nxt=cur+1;
                }else if(i==1){
                    nxt=cur-1;
                }else{
                    nxt=cur*2;
                }

                if(nxt==K){
                    time=count[cur];
                    ans++;
                }

                if(nxt>=0 && nxt<100000 && (count[nxt]==0 || count[nxt]==count[cur]+1)){
                    q.add(nxt);
                    count[nxt]=count[cur]+1;
                }
            }

        }
    }
}
