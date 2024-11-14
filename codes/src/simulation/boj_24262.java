package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_24262 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        //어떤 n이 들어오더라도 수행횟수와 수행시간은 항상 똑같음 = 상수 시간
        System.out.println(1);
        System.out.println(0);
    }
}
