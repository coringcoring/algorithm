package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1584 {
    static int N,M;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] map=new int[501][501];
    static int[][] dist=new int[501][501];
    //죽음 구역은 가중치 2, 위험 구역은 가중치 1, 안전구역은 가중치 0인 그래프를 탐색한다고 생각
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<N;i++){//위험한 구역
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            set(x1,y1,x2,y2,1);
        }
        M=Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            set(x1,y1,x2,y2,2);
        }

        //dist 배열 초기화
        for(int[] arr: dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dijkstra();

        System.out.println(dist[500][500]==Integer.MAX_VALUE ? -1: dist[500][500]);


    }
    public static void dijkstra(){
        PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(n->n.w));
        pq.offer(new Node(0,0,0));
        dist[0][0]=0;

        int nx,ny;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            if(dist[cur.y][cur.x]<cur.w){
                continue;
            }
            for(int i=0;i<dx.length;i++){
                nx=dx[i]+cur.x;
                ny=dy[i]+cur.y;

                if(nx<0 || nx>500 || ny<0 || ny>500) continue;
                if(map[ny][nx]==2) continue;
                if(dist[ny][nx]>dist[cur.y][cur.x]+map[ny][nx]){
                    dist[ny][nx]=dist[cur.y][cur.x]+map[ny][nx];
                    pq.offer(new Node(nx,ny,dist[ny][nx]));
                }
            }
        }

    }

    public static void set(int x1,int y1, int x2, int y2, int val){
        int startX=Math.min(x1,x2);
        int startY=Math.min(y1,y2);
        int endX=Math.max(x1,x2);
        int endY=Math.max(y1,y2);

        for(int x=startX;x<=endX;x++){
            for(int y=startY;y<=endY;y++){
                map[y][x]=val;
            }
        }
    }

    public static class Node{
        int x,y,w;
        public Node(int x, int y, int w){
            this.x=x;
            this.y=y;
            this.w=w;
        }
    }
}
