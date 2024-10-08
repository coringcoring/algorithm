package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//참고: https://st-lab.tistory.com/148
public class boj_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=Integer.MAX_VALUE;
        String[] str=br.readLine().split("-");

        //뺄셈을 기준으로 먼저 나누고, 덧셈끼리 먼저 계산 -> 최대한 덧셈값이 크도록

        for(int i=0;i<str.length;i++){
            int temp=0;

            String[] add=str[i].split("\\+");
            for(int j=0;j<add.length;j++){
                temp+=Integer.parseInt(add[j]);
            }

            if(sum==Integer.MAX_VALUE){
                sum=temp;
            }else{
                sum-=temp;
            }
        }
        System.out.println(sum);
    }
}
