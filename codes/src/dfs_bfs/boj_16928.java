package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//참고: https://jumping-to-the-water.tistory.com/117
public class boj_16928 {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[101];
        //1~100 초기화
        for(int i=1;i<arr.length;i++){
            arr[i]=i;
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[x]=y;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[x]=y;
        }

        bfs(1);
        br.close();
    }
    private static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        int[] visit=new int[101];

        q.offer(start);
        visit[start]=0;

        while(!q.isEmpty()){
            int cur=q.poll();

            for(int i=1;i<=6;i++){
                //다음 위치
                int nw=cur+i;

                if(nw<=0 || nw>100) continue;

                if(visit[arr[nw]]==0){//방문한적 없을때
                    q.offer(arr[nw]);
                    visit[arr[nw]]=visit[cur]+1;
                }
                if(arr[nw]==100){
                    System.out.println(visit[100]);
                    return;
                }
            }
        }
    }
}
