package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int ans=0;
            String s1=br.readLine();
            String s2=br.readLine();

            for(int j=0;j<s1.length();j++){
                if(s1.charAt(j)!=s2.charAt(j)) ans++;
            }
            sb.append("Hamming distance is ").append(ans).append(".\n");
        }

        System.out.println(sb);
    }
}
