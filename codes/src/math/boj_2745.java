package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        String N=st.nextToken();
        int B=Integer.parseInt(st.nextToken());

        int res=0;
        int temp=1;
        for(int i=N.length()-1;i>=0;i--){
            char c=N.charAt(i);
            if('A'<=c && c<='Z'){
                res+=(c-'A'+10)*temp;
            }else{
                res+=(c-'0')*temp;
            }
            temp*=B;
        }
        System.out.println(res);
    }
}
