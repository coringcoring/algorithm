package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int M=Integer.parseInt(br.readLine());
        int S=0;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String s=st.nextToken();
            if(s.equals("all")){
                S=(1<<21)-1;
            }else if (s.equals("empty")){
                S=0;
            }
            else{
                int num=Integer.parseInt(st.nextToken());

                if(s.equals("add")){
                    S|=(1<<num);
                }
                else if(s.equals("remove")){
                    S&=~(1<<num);
                }
                else if(s.equals("check")){
                    if((S&(1<<num))!=0){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                }
                else if(s.equals("toggle")){
                    S^=(1<<num);
                }
            }

        }
        System.out.println(sb);
    }
}
