package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        HashSet<String> set=new HashSet<String>();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            set.add(s);
        }

        int count=0;
        for(int i=0;i<M;i++){
            String s=br.readLine();
            if(set.contains(s)) count++;
        }
        System.out.println(count);
    }
}
