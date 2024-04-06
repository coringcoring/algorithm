package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//다른 방법: https://st-lab.tistory.com/103 의 방법2 참고
public class boj_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //666 1666 2666 3666 4666 5666 6660 6661 .. 6669 7666 ..
        //10666 11666 12666 13666 14666 15666 16660 16661 .. 16669 17666
        //60666 61666 62666 63666 64666 65666 66600 66601 .. 66699 67666

        int num=666;
        int count=1;
        while(count!=n){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }

        System.out.println(num);
    }

}
