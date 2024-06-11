package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        int count = 0;
        int result = 0;

        for(int i=1;i<=B;i++) {
            for(int j=1;j<=i;j++) {
                count++;

                if(A<=count && count<=B) {
                    result += i;
                }
            }
        }

        System.out.println(result);
    }
}
