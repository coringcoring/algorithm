package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        //분모 최소공배수 구하기
        int lcm;
        if(b>d){
            lcm=(b*d)/gcd(b,d);
        }else if(b<d){
            lcm=(b*d)/gcd(d,b);
        }else{
            lcm=b;
        }

        //분자 구하기
        int numerator=(lcm/b)*a+(lcm/d)*c;

        // 결과 분수의 기약분수 구하기
        int gcd_result = gcd(Math.abs(numerator), lcm);

        // 기약분수로 만들기
        numerator /= gcd_result;
        lcm /= gcd_result;

        System.out.println(numerator + " " + lcm);

    }

    private static int gcd(int a, int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
