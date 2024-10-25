package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {
    static int N,M;
    static int[][] arr;
    static int result=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        arr=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        int nx,ny;
        while(true) {
            if (arr[x][y] == 0) {
                result++;
                arr[x][y] = -1;
            }

            int i;
            for(i=0;i<4;i++){
                d=(d+3)%4;
                nx=x+dx[d];
                ny=y+dy[d];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(arr[nx][ny]==0){
                        x=nx;
                        y=ny;
                        break;
                    }
                }
            }

            if(i==4){
                nx=x+dx[(d+2)%4];
                ny=y+dy[(d+2)%4];
                if(nx<0 || nx>=N || ny<0 || ny>=M || arr[nx][ny]==1) break;
                else{
                    x=nx;
                    y=ny;
                }
            }
        }
        System.out.println(result);
    }
}
