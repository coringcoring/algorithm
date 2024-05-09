package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1446 {
    //https://velog.io/@gale4739/%EB%B0%B1%EC%A4%80-1446-%EC%A7%80%EB%A6%84%EA%B8%B8Java 참고
    static int N,D;
    static List<List<Node>> graph=new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        for(int i=0;i<=10002;i++){
            graph.add(new ArrayList<>());
        }
        dist=new int[10001];
        for(int i=0;i<dist.length;i++){
            dist[i]=i;
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,w));
        }

        dijkstra(0);
        System.out.println(dist[D]);
    }

    static void dijkstra(int start){
        if(start>D){
            return;
        }
        if(dist[start+1]>dist[start]+1){
            dist[start+1]=dist[start]+1;
        }
        for(int i=0;i<graph.get(start).size();i++){
            if(dist[start]+graph.get(start).get(i).weight <dist[graph.get(start).get(i).node]){
                dist[graph.get(start).get(i).node]=dist[start]+graph.get(start).get(i).weight;
            }
        }
        dijkstra(start+1);
    }

    static class Node{
        int node;
        int weight;
        Node(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
}
