package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_24264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Long n=Long.parseLong(br.readLine());
        System.out.println(n*n);
        System.out.println(2); //차수는 항상 2: n^2
    }
}
