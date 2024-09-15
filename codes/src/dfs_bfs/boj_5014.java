package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014 {
    static int F,S,G,U,D;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        F=Integer.parseInt(st.nextToken()); //총 개수
        S=Integer.parseInt(st.nextToken()); //출발층
        G=Integer.parseInt(st.nextToken()); //목표층
        U=Integer.parseInt(st.nextToken()); //위로
        D=Integer.parseInt(st.nextToken()); //아래로

        visit=new boolean[F+1];
        arr=new int[F+1];

        boolean isFind=bfs(S);

        if(isFind){
            System.out.println(arr[G]);
        }else{
            System.out.println("use the stairs");
        }


    }
    private static boolean bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visit[start]=true;


        while(!q.isEmpty()){
            int cur=q.poll();

            if(cur==G){
                return true;
            }

            for(int i=0;i<2;i++){
                int nxt;
                if(i==0){
                    nxt=cur+U;
                }else{
                    nxt=cur-D;
                }

                if(nxt>0 && nxt<=F && !visit[nxt]){
                    q.add(nxt);
                    visit[nxt]=true;
                    arr[nxt]=arr[cur]+1;
                }
            }
        }

        return false;
    }

}
