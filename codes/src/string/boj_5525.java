package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5525 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        char[] S=br.readLine().toCharArray();

        int count=0;
        int ans=0;
        for(int i=0;i<M-2;){
            if(S[i]=='I' && S[i+1]=='O'){
                count++;
                if(count==N){
                    if(S[i+2]=='I')
                        ans++;
                    count--;
                }
                i+=2;
            }else{
                count=0;
                i++;
            }
        }

        System.out.println(ans);
    }
}
