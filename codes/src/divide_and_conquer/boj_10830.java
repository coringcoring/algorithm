package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10830 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        long B=Long.parseLong(st.nextToken()); //B의 범위: 1~천억이므로

        arr=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken())%1000;
            }
        }
        int[][] result=pow(arr,B);

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    //행렬 제곱 분할정복 메소드
    private static int[][] pow(int[][] a, long exp){
        //지수가 1: a를 그대로 return
        if(exp==1L){
            return a;
        }
        //지수를 절반으로 분할하여 재귀호출
        int[][] mid=pow(a,exp/2);

        //하위 재귀에서 얻은 행렬을 제곱
        mid=multiply(mid,mid);
        if(exp%2==1L){
            mid=multiply(mid,arr); //arr은 A^1 -> 홀수라면 한번 더 곱해줌
        }

        return mid;
    }

    private static int[][] multiply(int[][] a,int[][] b){
        int[][] res=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    res[i][j]+=a[i][k]*b[k][j];
                    res[i][j]%=1000;
                }
            }
        }
        return res;
    }

}
