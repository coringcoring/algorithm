package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_12852 {
    static int N;
    static int[] count;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        count=new int[N+1];
        parent=new int[N+1];

        bfs();
        System.out.println(count[1]);

        // N부터 1까지의 경로 출력
        StringBuilder sb = new StringBuilder();
        int cur = 1;
        LinkedList<Integer> path = new LinkedList<>();

        // 경로를 거꾸로 저장
        while (cur != 0) {
            path.addFirst(cur);  // 앞쪽에 추가
            cur = parent[cur];
        }

        // 경로 출력
        for (int num : path) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);

    }
    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        parent[N]=0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur==1) break;

            if(cur%3==0){
                int nxt=cur/3;
                if(count[nxt]==0 && nxt!=N){
                    queue.add(nxt);
                    count[nxt]=count[cur]+1;
                    parent[nxt]=cur;
                }
            }
            if(cur%2==0){
                int nxt=cur/2;
                if(count[nxt]==0 && nxt!=N){
                    queue.add(cur/2);
                    count[nxt]=count[cur]+1;
                    parent[nxt]=cur;
                }
            }

            int nxt=cur-1;
            if(nxt>0 && count[nxt]==0 && nxt!=N){
                queue.add(nxt);
                count[nxt]=count[cur]+1;
                parent[nxt]=cur;
            }
        }

    }
}
