package string;

import java.io.*;
import java.util.ArrayList;

public class boj_3107 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String s=br.readLine();

        if(s.contains("::")){
            s=s.replace("::",":zeros:");
        }
        //:을 기준으로 분리
        String[] s2=s.split(":");

        ArrayList<String> input=new ArrayList<>();
        ArrayList<String> result=new ArrayList<>();

        for(int i=0;i<s2.length;i++){
            input.add(s2[i]);
        }

        for(int i=0;i<input.size();i++){
            String nxt=input.get(i);

            if(nxt.isEmpty()) continue;

            while(nxt.length()<4){
                nxt="0"+nxt;
            }

            result.add(nxt);
        }

        String[] ip=new String[8];
        //공백 or 생략되어 있어서 0000으로 바꾸어야할 개수
        int zero=8-result.size()+1;
        int idx=0;
        for(int i=0;i<result.size();i++){
            if(result.get(i).equals("zeros")){
                while(zero-->0){
                    ip[idx]="0000";
                    idx++;
                }
            }else{
                ip[idx]=result.get(i);
                idx++;
            }
        }

        for(int i=0;i<7;i++){
            bw.write(ip[i]+":");
        }
        bw.write(ip[7]+"\n");

        bw.flush();
        bw.close();
    }
}
