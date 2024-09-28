package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj_1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //EOF처리를 위한 입력값을 받을 문자열 input
        String input;
        //input에 저장된 문자열을 합치기위한 문자열 변수
        String S = "";

        //while의 조건문에 있는 것이 EOF에러 해결
        while ((input = br.readLine()) != null) {
            S += input;
        }

        int max = 0;
        String Smax = "";

        for (char i = 97; i < 123; i++) {
            int count = S.length() - S.replace(String.valueOf(i), "").length();

            if (max == count) {
                Smax += String.valueOf(i);
            }

            if (max < count) {
                max = count;
                Smax = String.valueOf(i);
            }
        }
        System.out.println(Smax);
    }
}