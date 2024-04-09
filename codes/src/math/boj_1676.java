package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        BigInteger number=BigInteger.valueOf(1);
        int count=0;

        for(int i=1;i<=n;i++){
            number=number.multiply(BigInteger.valueOf(i));
        }

        String s=String.valueOf(number);

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                count++;
            }else{
                break;
            }
        }

        System.out.println(count);

    }
}
