package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2583 {
    static int M,N,K;
    static int[][] arr;
    static Queue<int[]> q=new LinkedList<>();

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        arr=new int[N][M];
        LinkedList<Integer> areas=new LinkedList<>();

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());


            for(int x=x1;x<x2;x++){
                for(int y=y1;y<y2;y++){
                    if(arr[x][y]!=1){
                        arr[x][y]=1;
                    }
                }
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    q.add(new int[]{i,j});
                    areas.add(bfs());
                }
            }
        }

        Collections.sort(areas);

        System.out.println(areas.size());
        for(int area: areas){
            System.out.print(area+" ");
        }

        br.close();
    }

    private static int bfs(){
        int area=0;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            area++;

            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny]!=1){
                    q.add(new int[]{nx,ny});
                    arr[nx][ny]=1;
                }
            }
        }

        return area;
    }
}
