package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());

        if(a>b){
            sb.append(a*b/gcd(a,b)).append("\n");
        }else if(a<b){
            sb.append(a*b/gcd(b,a)).append("\n");
        }else{
            sb.append(a).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static long gcd(long a, long b){
        while(b!=0){
            long r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
