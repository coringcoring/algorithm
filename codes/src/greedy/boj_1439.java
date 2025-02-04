package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] c=br.readLine().toCharArray();

        int count0=0;
        int count1=0;

        if(c[0]=='0') {
            count0++;
        }
        else{
            count1++;
        }

        for(int i=1;i<c.length;i++){
            if(c[i-1]!=c[i]){
                if(c[i]=='0'){
                    count0++;
                }else{
                    count1++;
                }
            }
        }

        System.out.println(Math.min(count0,count1));

    }
}
