package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11779 {
    private static class Node implements Comparable<Node>{
        int v;
        int cost;
        Node(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost-o.cost;
        }
    }
    static int N,M,start,end;
    static int[] dist;
    static int[] route;
    static boolean[] visit;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine()); //정점 개수
        M=Integer.parseInt(br.readLine()); //간선 개수

        graph=new ArrayList[N+1];
        dist=new int[N+1];
        route=new int[N+1];
        visit=new boolean[N+1];

        for(int i=1;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        Arrays.fill(dist,Integer.MAX_VALUE);

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,e));
        }

        st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());


        dijkstra();
        System.out.println(dist[end]);

        ArrayList<Integer> results=new ArrayList<>();
        int idx=end;
        while(idx!=0){
            results.add(idx);
            idx=route[idx];
        }
        System.out.println(results.size());
        for(int i= results.size()-1;i>=0;i--){
            System.out.print(results.get(i)+" ");
        }

    }
    private static void dijkstra(){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start]=0;
        route[start]=0;

        while(!pq.isEmpty()){
            Node cur=pq.poll();

            if(visit[cur.v]) continue;

            for(int i=0;i<graph[cur.v].size();i++){
                Node nxt=graph[cur.v].get(i);
                if(dist[nxt.v]>nxt.cost+dist[cur.v]){
                    dist[nxt.v]=nxt.cost+dist[cur.v];
                    pq.add(new Node(nxt.v,dist[nxt.v]));
                    visit[cur.v]=true;
                    route[nxt.v]=cur.v;
                }
            }
        }

    }
}
