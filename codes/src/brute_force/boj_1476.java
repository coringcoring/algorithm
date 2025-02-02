package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int E=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());


        if(E==1 && S==1 && M==1){
            System.out.println(1);
            return;
        }

        //count할 용도의 변수
        int e=1;
        int s=1;
        int m=1;

        int result=1;
        while(true){
            if(e==E && s==S && m==M){
                break;
            }
            e++;
            s++;
            m++;
            result++;

            if(e>15){
                e=1;
            }
            if(s>28){
                s=1;
            }
            if(m>19) {
                m = 1;
            }
        }

        System.out.println(result);
    }
}
