package bellman;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11657 {
    static int N,M;
    static long dist[];
    static Node nodeArr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        nodeArr=new Node[M+1];
        dist=new long[N+1];
        for(int i=1;i<=N;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int time=Integer.parseInt(st.nextToken());

            nodeArr[i]=new Node(start,end,time);
        }
        StringBuilder sb=new StringBuilder();

        if(bellman()){
            for(int i=2;i<=N;i++){
                sb.append(dist[i]==Integer.MAX_VALUE ? "-1\n": dist[i]+"\n");
            }
        }else{
            sb.append("-1\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    private static boolean bellman(){
        dist[1]=0;

        for(int i=1;i<N;i++){
            for(int j=0;j<M;j++){
                Node node =nodeArr[j];
                // 더 작은 최단거리 있을 경우 업데이트
                if(dist[node.start]!=Integer.MAX_VALUE && dist[node.end] > dist[node.start]+node.weight){
                    dist[node.end]=dist[node.start]+node.weight;
                }
            }
        }
        //음의 사이클 확인
        //업데이트가 된다는 것 ==음의 사이클이 있음을 의미
        for(int i=0;i<M;i++){
            Node node=nodeArr[i];
            if(dist[node.start]!=Integer.MAX_VALUE && dist[node.end] > dist[node.start]+node.weight){
                return false;
            }
        }
        return true;
    }
}

class Node{
    int start,end,weight;
    public Node(int start,int end, int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
}
