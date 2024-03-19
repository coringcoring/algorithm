package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] chk;
    static int[][] arr;

    static int node, edge, start;

    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        node=Integer.parseInt(st.nextToken());
        edge=Integer.parseInt(st.nextToken());
        start=Integer.parseInt(st.nextToken());

        arr=new int[node+1][node+1]; //인접 행렬 사용 : 숫자가 낮은 노드부터 탐색해야하므로
        chk=new boolean[node+1];

        for(int i=0;i<edge;i++){ //edge만큼 반복해서 입력 받음
            StringTokenizer st2= new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st2.nextToken());
            int b=Integer.parseInt(st2.nextToken());

            arr[a][b]=arr[b][a]=1;
        }

        dfs(start);
        sb.append("\n");
        chk=new boolean[node+1];
        bfs(start);

        System.out.println(sb);


    }

    public static void dfs(int start){ //재귀 사용
        chk[start]=true;
        sb.append(start+" ");

        for(int i=0;i<=node;i++){
            if (arr[start][i]==1 && !chk[i])
                dfs(i);
        }
    }

    public static void bfs(int start){//큐 사용
        q.add(start);
        chk[start]=true;

        while(!q.isEmpty()){
            start=q.poll();
            sb.append(start+" ");

            for(int i=1;i<=node;i++){
                if(arr[start][i]==1 && !chk[i]){
                    q.add(i);
                    chk[i]=true;
                }
            }
        }
    }
}
