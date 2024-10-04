package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        //LinkedHashset<String> 을 사용해야함
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(int i=0;i<L;i++){
            String s=br.readLine();
            if(set.contains(s)){
                set.remove(s);
            }
            set.add(s);
        }

        for(String s:set){
            if(k>0){
                System.out.println(s);
                k--;
            }
        }
    }
}
