package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485 {
    static int N;
    static int[][] graph;
    static boolean[][] visit;
    static int[][] dist;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static StringBuilder sb=new StringBuilder();

    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int d;
        Node(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int prob=0;

        while(true){
            N=Integer.parseInt(br.readLine());
            if(N==0){
                break;
            }
            graph=new int[N][N];
            visit=new boolean[N][N];
            dist=new int[N][N];


            prob++;
            sb.append("Problem "+prob+": ");
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    graph[i][j]=Integer.parseInt(st.nextToken());
                    dist[i][j] = 987654321;
                }
            }

            dijkstra();
            sb.append(dist[N-1][N-1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra(){
        visit[0][0]=true;
        dist[0][0]=graph[0][0];

        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(0,0,dist[0][0]));

        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int x=cur.x;
            int y=cur.y;

            for(int i=0;i<4;i++){
                int nx=dx[i]+x;
                int ny=dy[i]+y;

                if(nx<0 || nx>=N || ny<0 || ny>=N || visit[nx][ny]) continue;

                if(dist[nx][ny]>dist[x][y]+graph[nx][ny]){
                    dist[nx][ny]=dist[x][y]+graph[nx][ny];
                    pq.add(new Node(nx,ny,dist[nx][ny]));
                    visit[nx][ny]=true;
                }
            }
        }
    }
}
