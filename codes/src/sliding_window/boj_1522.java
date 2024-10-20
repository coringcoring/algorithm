package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//참고: https://velog.io/@jho7535/%EB%B0%B1%EC%A4%80-JAVA-1522%EB%B2%88-%EB%AC%B8%EC%9E%90%EC%97%B4-%EA%B5%90%ED%99%98
public class boj_1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str= br.readLine().toCharArray();

        int a_len=0; //전체 문자열에서 a의 개수
        for(int i=0;i<str.length;i++){
            if(str[i]=='a') a_len++;
        }


        int max=0; //부분 문자열에서 a 개수 최댓값 저장
        for(int i=0;i<str.length;i++){
            int count=0; //부분 문자열에서 a 개수 카운트

            for(int j=0;j<a_len;j++){
                //원형이기 때문에 인덱스 범위가 넘어가면 다시 처음부터 되도록 해야함
                int index=(i+j<str.length ? i+j : i+j-str.length);

                if(str[index]=='a') count++;
                if(count>max) max=count;
            }
        }
        //전체 a 개수 - 최대 a의 개수 = 교환해야하는 b의 개수
        System.out.println(a_len-max);
    }
}
