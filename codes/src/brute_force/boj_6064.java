package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            int M=Integer.parseInt(st.nextToken());
            int N=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            solve(x,y,M,N);
        }
    }
    private static void solve(int x,int y, int M,int N){
        boolean flag=false;
        x--;
        y--;
        for(int j=x;j<=M*N;j+=M){
            if(j%N==y){
                flag=true;
                System.out.println(j+1);
                break;
            }
        }

        if(!flag){
            System.out.println("-1");
        }
    }
}
