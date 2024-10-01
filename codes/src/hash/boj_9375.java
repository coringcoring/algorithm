package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 참고: https://st-lab.tistory.com/164

public class boj_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            HashMap<String,Integer> map=new HashMap<>();

            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                st.nextToken();
                String s=st.nextToken();

                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else{
                    map.put(s,1);
                }
            }
            int result=1;
            for(int val:map.values()){
                result*=(val+1);
            }
            sb.append(result-1).append("\n");
        }
        System.out.print(sb);
    }
}
