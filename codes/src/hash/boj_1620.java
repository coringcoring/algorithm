package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        HashMap<Integer,String> hash1=new HashMap<Integer,String>();
        HashMap<String,Integer> hash2=new HashMap<String,Integer>();

        for(int i=1;i<=N;i++){
            String s=br.readLine();
            hash1.put(i,s);
            hash2.put(s,i);
        }
        for(int i=0;i<M;i++){
            String s=br.readLine();
            if(s.charAt(0)>=49 && s.charAt(0)<=57){
                sb.append(hash1.get(Integer.parseInt(s))).append("\n");
            }else{
                sb.append(hash2.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
