package dfs_bfs;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class boj_2667 {
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static List<Integer> res=new LinkedList<>();
    static int count=1; //처음 탐색하는 첫 아파트가 포함되므로 1로 초기화해야함!
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(br.readLine());
        arr=new int[n][n];
        visit=new boolean[n][n];
        for(int i=0;i<n;i++){
            String line=br.readLine();
            for(int j=0;j<n;j++){
                char c=line.charAt(j);
                arr[i][j]=Character.getNumericValue(c);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && !visit[i][j]){
                    dfs(i,j);
                    res.add(count);
                    count=1;
                }
            }
        }
        Collections.sort(res);
        bw.write(res.size()+"\n");
        for(int i:res){
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int x,int y){
        visit[x][y]=true;
        //방향 배열로 주변을 탐색해야함
        for(int i=0;i<4;i++){
            int nx=dx[i]+x;
            int ny=dy[i]+y;
            if(nx>=0 && ny>=0 && nx<n && ny<n && !visit[nx][ny] && arr[nx][ny]==1){
                count++;
                dfs(nx,ny);
            }
        }
    }
}
