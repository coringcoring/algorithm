package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//문제 이해가 어려웠음. 꼼꼼히 문제를 읽어봅시다.
//모든 육지의 각 지점에서 다른 모든 육지 지점까지의 거리를 구한 후, 최고거리인 지점까지 걸리는 시간
public class boj_2589 {
    static int N,M;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visit;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new char[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=s.charAt(j);
            }
        }

        int max=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]=='L'){
                    visit=new boolean[N][M];
                    int length=bfs(i,j);
                    max=Math.max(length,max);
                }
            }
        }

        System.out.println(max);
    }
    private static int bfs(int x,int y){
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(x,y,0));
        visit[x][y]=true;

        int len=0;
        while(!q.isEmpty()){
            Node cur=q.poll();

            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(!visit[nx][ny] && arr[nx][ny]=='L'){
                    q.offer(new Node(nx,ny,cur.val+1));
                    len=Math.max(len,cur.val+1);
                    visit[nx][ny]=true;
                }

            }
        }

        return len;
    }

    private static class Node{
        int x;
        int y;
        int val;

        public Node(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }
}
