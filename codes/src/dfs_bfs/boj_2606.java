package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2606 {
    static StringBuilder sb = new StringBuilder();
    static int node,edge;
    static int[][] arr; //인접 행렬로 구현
    static boolean[] chk; //방문 여부

    static int count=0; //결과
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        node=Integer.parseInt(br.readLine());
        edge=Integer.parseInt(br.readLine());

        arr=new int[node+1][node+1];
        chk=new boolean[node+1];

        for(int i=0;i<edge;i++){ //인접행렬 입력받고 넣기
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=1;
            arr[b][a]=1;
        }

        bfs(1);
        sb.append(count);
        System.out.println(sb);

    }

    public static void bfs(int start){
        q.add(start);
        chk[start]=true;

        while(!q.isEmpty()){
            start=q.poll();
            for(int i=1;i<=node;i++){
                if(arr[start][i]==1 && !chk[i]){
                    q.add(i);
                    chk[i]=true;
                    count++;
                }
            }
        }
    }
}
