package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_18352 {
    static int N,M,K,X;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        //초기화
        arr=new int[N+1];
        graph=new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        Arrays.fill(arr,(int)1e9);
        arr[X]=0;

        //입력
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        //다익스트라
        dijkstra(X);
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==K){
                System.out.println(i);
                count++;
            }
        }
        if(count==0) System.out.println(-1);
    }

    static void dijkstra(int start){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(start);
        while(!pq.isEmpty()){
            int now=pq.poll();
            for(int j=0;j<graph.get(now).size();j++){
                int cost=arr[now]+1;
                if(cost<arr[graph.get(now).get(j)]){
                    arr[graph.get(now).get(j)]=cost;
                    pq.add(graph.get(now).get(j));
                }
            }
        }
    }
}
