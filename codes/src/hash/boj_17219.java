package hash;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        HashMap<String,String> map=new HashMap<>();

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            map.put(st.nextToken(),st.nextToken());
        }

        for(int i=0;i<m;i++){
            String s=br.readLine();
            sb.append(map.get(s)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
