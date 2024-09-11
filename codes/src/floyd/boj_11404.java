package floyd;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        int[][] arr=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j]=987654321;

                if(i==j){
                    arr[i][j]=0;
                }
            }
        }

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            arr[a][b]=Math.min(arr[a][b],c); //중복 경로 값이 들어올 수 있어서 최소값이 들어가도록 해야함
        }

        //플로이드-와샬
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(arr[i][j]>arr[i][k]+arr[k][j]){
                        arr[i][j]=arr[i][k]+arr[k][j];
                    }
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(arr[i][j]==987654321){
                    arr[i][j]=0;
                }
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
