package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17144 {
    static int R,C,T;
    static int[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        arr=new int[R][C];

        for(int i=0;i<R;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]>0){
                    for(int k=0;k<4;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];


                    }
                }
            }
        }



    }
}
