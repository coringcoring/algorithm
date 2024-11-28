package topology_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2637 {
    static class Node{
        int a;
        int val;

        private Node(int a,int val){
            this.a = a;
            this.val = val;
        }
    }

    static int N;
    static int M;
    static List<Node>[] list;
    static int[] indegree;
    static int[] indegree_x;
    static int[] needs;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());

        list=new List[N+1];
        indegree=new int[N+1];
        needs=new int[N+1];
        indegree_x=new int[N+1];

        for(int i=0;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            list[x].add(new Node(y,k));
            indegree[y]++;
            indegree_x[x]++;
        }
        topology();
        for(int i=1;i<=N;i++){
            if(indegree_x[i]==0){
                System.out.println(i+" "+needs[i]);
            }
        }

    }

    private static void topology(){
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(N,1));
        needs[N]=1;

        while(!q.isEmpty()){
            Node cur=q.poll();

            for(int i=0;i<list[cur.a].size();i++){
                Node nxt=list[cur.a].get(i);
                needs[nxt.a]+=needs[cur.a]*nxt.val;
                indegree[nxt.a]--;
                if(indegree[nxt.a]==0){
                    q.offer(new Node(nxt.a,needs[nxt.a]));
                }
            }
        }
    }
}
