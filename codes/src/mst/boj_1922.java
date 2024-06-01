package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> lst=new LinkedList<>();
        boolean[] visit=new boolean[N+1];

        for(int i=0;i<N+1;i++){
            lst.add(new LinkedList<>());
        }
        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int val=Integer.parseInt(st.nextToken());

            lst.get(A).add(new Node(B,val));
            lst.get(B).add(new Node(A,val));
        }

        Queue<Node> q=new PriorityQueue<>();
        for(int i=0;i<lst.get(1).size();i++){
            q.offer(lst.get(1).get(i));
        }
        visit[1]=true;
        int sum=0;

        while(!q.isEmpty()){
            Node a=q.poll();

            if(visit[a.B]){
                continue;
            }
            visit[a.B]=true;
            sum+=a.val;
            for(int i=0;i<lst.get(a.B).size();i++){
                q.offer(lst.get(a.B).get(i));
            }
        }
        System.out.println(sum);
    }

    static class Node implements Comparable<Node>{
        int B,val;

        Node(int B,int val){
            this.B=B;
            this.val=val;
        }

        @Override
        public int compareTo(Node a){
            return val-a.val;
        }
    }

}
