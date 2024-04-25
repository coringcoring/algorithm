package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String str;
        while((str=br.readLine())!=null){
            StringTokenizer st=new StringTokenizer(str);
            char[] s=st.nextToken().toCharArray();
            char[] t=st.nextToken().toCharArray();
            int i=0;
            String result="No";

            for(char c:t){
                if(s[i]==c){
                    i++;
                }
                if(i==s.length){
                    result="Yes";
                    break;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);

    }
}
