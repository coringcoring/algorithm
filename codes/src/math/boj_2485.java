package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] tree=new int[N];
        for(int i=0;i<N;i++){
            tree[i]=Integer.parseInt(br.readLine());
        }

        int gcd=0;
        for(int i=0;i<N-1;i++){
            int diff=tree[i+1]-tree[i];
            gcd=gcd(diff,gcd);
        }

        System.out.println((tree[N-1]-tree[0])/gcd+1-(tree.length)+"");

    }
    private static int gcd(int a,int b){
        while(b!=0){
            int tmp=a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
}
