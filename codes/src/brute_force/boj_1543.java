package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//참고: https://comain.tistory.com/313
public class boj_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String arr=br.readLine();
        String s=br.readLine();

        int size=arr.length();
        int size2=s.length();

        arr=arr.replace(s,"");
        System.out.println((size-arr.length())/size2);
    }
}
