package dfs_bfs;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1012 { //2667번과 유사한 문제
    static int t,m,n,k;
    static int[][] arr;
    static boolean[][] visit;
    //좌, 우, 상, 하 방향
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int result=0;
            StringTokenizer st=new StringTokenizer(br.readLine());
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            arr=new int[m][n];
            visit=new boolean[m][n];
            for(int j=0;j<k;j++){
                StringTokenizer st2=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st2.nextToken());
                int b=Integer.parseInt(st2.nextToken());
                arr[a][b]=1;
            }

            //dfs 탐색
            for(int x=0;x<m;x++){
                for(int y=0;y<n;y++){
                    if(arr[x][y]==1 && !visit[x][y]){
                        dfs(x,y);
                        result++;
                    }
                }
            }
            bw.write(result+"\n");
            bw.flush();
        }

        bw.close();
    }
    public static void dfs(int x,int y){
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int new_x=dx[i]+x;
            int new_y=dy[i]+y;
            if(new_x>=0 && new_y>=0 && new_x<m && new_y<n && !visit[new_x][new_y]&& arr[new_x][new_y]==1){
                dfs(new_x,new_y);
            }
        }
    }
}
