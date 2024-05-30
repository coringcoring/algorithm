package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라: 한 노드에서 모든 노드로 가는 최단거리 구할 수 있음
//최단거리를 저장하는 배열+ 우선순위 큐 사용하여 구현 가능

public class boj_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(br.readLine());

        boolean[] visit=new boolean[V+1];//방문 검사 배열
        int[] dist=new int[V+1]; //최단 경로값 저장 배열
        List<Node>[] lst=new List[V+1];//연결 정보 저장 배열

        for(int i=1;i<=V;i++){
            lst[i]=new ArrayList<>(); //방향 그래프이므로..
            dist[i]=Integer.MAX_VALUE; //최대값으로 초기화
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            lst[u].add(new Node(v,w)); //u 노드가 v노드와 w의 가중치로 연결됨
        }

        //다익스트라
        PriorityQueue<Node> q=new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
        dist[K]=0; //출발 노드는 0으로 초기화 필요
        q.add(new Node(K,0)); //출발노드는 weight가 무조건 0

        while(!q.isEmpty()){
            Node cur=q.poll(); //현재 방문하는 노드
            if(!visit[cur.end]) visit[cur.end]=true; //방문처리

            //현재 노드와 연결된 간선들 판단
            //노드 1과 연결된 노드들이 lst에 1: [(2,3),(3,4)] 이런식으로 있을 수 있음
            for(int i=0;i<lst[cur.end].size();i++){
                Node nxt=lst[cur.end].get(i);

                //ex. 노드 2를 방문하지 않았고 && 현재 노드(1)의 가중치(weight=0)+노드 2로 가는 가중치값(weight=3)<노드 2로의 최단경로값(dist[2])라면
                if(!visit[nxt.end] && cur.weight+nxt.weight<dist[nxt.end]){
                    dist[nxt.end]=cur.weight+nxt.weight;
                    q.add(new Node(nxt.end,dist[nxt.end]));
                }
            }
        }

        for(int i=1;i<=V;i++){
            if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    static class Node{
        int end;
        int weight;

        public Node(int end,int weight){
            this.end=end;
            this.weight=weight;
        }
    }
}
