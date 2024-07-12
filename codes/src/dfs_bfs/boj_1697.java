package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
    static int N,K;
    static boolean[] visit=new boolean[100001]; //방문 체크
    static int[] count=new int[100001]; //각 위치까지의 최소 이동 횟수 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        if(N==K){ //if N=K=5인 경우, 0이 출력되어야하지만 bfs시, 2가 출력되므로 따로 처리해주어야함
            System.out.println(0);
        }else{
            bfs(N);
        }
        ;
    }
    private static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visit[start]=true;
        count[start]=1;

        while(!q.isEmpty()){
            int cur=q.poll();

            //뒤로 1칸, 앞으로 1칸, 2*x칸
            for(int i=0;i<3;i++){
                int next;
                if(i==0){
                    next=cur+1;
                }else if(i==1){
                    next=cur-1;
                }else{
                    next=cur*2;
                }

                if(next==K){
                    System.out.println(count[cur]);
                    return;
                }

                if(next>=0 && next< visit.length && !visit[next] && count[next]==0){
                    q.add(next);
                    visit[next]=true;
                    count[next]=count[cur]+1;
                }
            }

        }

    }
}
