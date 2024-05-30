package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//Collections.sort(List<Node>)를 사용하기 위해 -> Node 객체들이 val값을 기준으로 정렬되도록
class Node implements Comparable<Node>{
    int A,B,val;
    Node(int A,int B,int val){
        this.A=A;
        this.B=B;
        this.val=val;
    }
    @Override
    public int compareTo(Node a){//val을 오름차순으로 정렬
        int val=a.val;
        if(this.val>val) return 1;
        else return -1;
    }
}

public class boj_1197 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());

        List<Node> lst=new ArrayList<>();

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int val=Integer.parseInt(st.nextToken());

            lst.add(new Node(A,B,val));
        }

        Collections.sort(lst);

        int sum=0;
        parent=new int[V+1];
        for(int i=1;i<=V;i++){
            parent[i]=i;
        }

        //Kruskal
        for(Node node: lst){
            int A=node.A;
            int B=node.B;
            int val=node.val;

            if(find(A)==find(B)){
                continue;
            }

            sum+=val;
            union(A,B);
        }
        System.out.println(sum);

    }

    static int find(int A){
        if(parent[A]==A){
            return A;
        }else{
            return find(parent[A]);
        }
    }

    static void union(int A,int B){
        int a=find(A);
        int b=find(B);

        if(a!=b){
            parent[b]=a;
        }
    }
}

