package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1261 {
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int val;
        Node(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
        @Override
        public int compareTo(Node o){
            return this.val-o.val; //오름 차순 정렬
        }
    }
    static int M,N;
    static int[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        visit=new boolean[N+1][M+1];
        arr=new int[N+1][M+1];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        int res=bfs();

        System.out.println(res);
    }

    private static int bfs(){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        visit[0][0]=true;
        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()){
            Node cur=pq.poll();

            int x=cur.x;
            int y=cur.y;
            int val=cur.val;

            if(x==N-1 && y==M-1){
                return val;
            }

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny]) continue;

                if(arr[nx][ny]==0) pq.add(new Node(nx,ny,val));
                else {
                    pq.add(new Node(nx, ny, val + 1));
                }
                visit[nx][ny]=true;
            }
        }
        return 0;
    }
}

