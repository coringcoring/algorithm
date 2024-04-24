package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992 {
    //분할정복... 이었음
    //https://st-lab.tistory.com/230 를 참고함
    static int[][] arr;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr=new int[N+1][N+1];
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<N;j++){
                char c=s.charAt(j);
                arr[i][j]=Character.getNumericValue(c);
            }
        }
        solve(0,0,N);
        System.out.println(sb);
    }

    public static void solve(int x,int y,int size){
        if(isPossible(x,y,size)){
            sb.append(arr[x][y]);
            return;
        }
        int newSize=size/2;
        sb.append('(');

        solve(x,y,newSize);
        solve(x,y+newSize,newSize);
        solve(x+newSize,y,newSize);
        solve(x+newSize,y+newSize,newSize);

        sb.append(')');
    }

    public static boolean isPossible(int x,int y,int size){
        int val=arr[x][y];

        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(val!=arr[i][j])
                    return false;
            }
        }

        return true;
    }
}
