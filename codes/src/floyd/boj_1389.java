package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1389 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int[][] arr=new int[N+1][N+1];
        int[] bacon=new int[N+1];
        for(int i=0;i<N+1;i++){
            bacon[i]=0;
        }

        for(int i=0;i<N+1;i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE/2);
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            arr[a][b]=1;
            arr[b][a]=1;
        }

        //플로이드-와샬
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }


        //베이컨 수 count
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i!=j && arr[i][j]!=Integer.MAX_VALUE/2){
                    bacon[i]+=arr[i][j];
                }
            }
        }

        int min=Integer.MAX_VALUE/2;
        int min_index=0;
        for(int i=1;i<=N;i++){
            if(bacon[i]<min){
                min_index=i;
                min=bacon[i];
            }
        }
        System.out.println(min_index);
    }
}
