package bellman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1865 {
    //웜홀 = 음수 가중치 간선 -> 다익스트라 사용 불가능
    //따라서 음의 사이클이 존재하는지(웜홀) 검사하면 됨
    private static class Node{
        int v;
        int val;
        Node(int v,int val){
            this.v=v;
            this.val=val;
        }
    }

    static final int INF=987654321;
    static int N,M,W;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());

            dist=new int[N+1];
            graph=new ArrayList<>();
            for(int j=0;j<N+1;j++){
                graph.add(new ArrayList<>());
            }

            for(int j=0;j<M+W;j++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());

                if(j<M){
                    graph.get(a).add(new Node(b,c));
                    graph.get(b).add(new Node(a,c));
                }
                else{ //음의 가중치 간선인 경우
                    graph.get(a).add(new Node(b,-c));
                }
            }
            boolean result=bellman();
            if(result){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        br.close();
    }

    private static boolean bellman(){
        Arrays.fill(dist,INF);
        dist[1]=0; //시작점 정함
        boolean update=false;

        for(int i=1;i<N;i++){//정점 개수 -1 번 동안 최단거리 초기화 작업
            update=false;

            for(int j=1;j<=N;j++){
                for(Node node: graph.get(j)){
                    if(dist[node.v]>dist[j]+node.val){
                        dist[node.v]=dist[j]+node.val;
                        update=true;
                    }
                }
            }

            if(!update){
                break;
            }
        }

        if(update){
            for(int i=1;i<=N;i++){
                for(Node node:graph.get(i)){
                    if(dist[node.v]>dist[i]+node.val){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
