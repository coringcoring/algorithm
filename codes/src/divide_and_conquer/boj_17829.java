package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17829 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        arr=new int[N+1][N+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int result=solve(0,0,N);

        System.out.println(result);

    }

    private static int solve(int i,int j,int size){
        if(size==2){
            int[] res =new int[4];
            int idx=0;
            for(int a=i;a<i+2;a++){
                for(int b=j;b<j+2;b++){
                    res[idx++]=arr[a][b];
                }
            }
            Arrays.sort(res);
            return res[2];
        }
        else{
            int[] res=new int[4];
            int newSize=size/2;

            res[0]=solve(i,j,newSize);
            res[1]=solve(i,j+newSize,newSize);
            res[2]=solve(i+newSize,j,newSize);
            res[3]=solve(i+newSize,j+newSize,newSize);

            Arrays.sort(res);
            return res[2];
        }
    }
}
