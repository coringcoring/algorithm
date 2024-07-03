package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4779 {
    static int n;
    static StringBuilder ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            n=Integer.parseInt(s);
            ans=new StringBuilder();
            int len=(int) Math.pow(3,n);

            for(int i=0;i<len;i++){
                ans.append("-");
            }
            solve(0,len);
            System.out.println(ans);
        }
    }

    private static void solve(int start,int size){
        if(size==1){
            return;
        }
        int newSize=size/3;

        for(int i=start+newSize;i<start+2*newSize;i++){
            ans.setCharAt(i,' '); //3등분 중 2번째 파트는 공백처리
        }
        solve(start,newSize); //3등분한 문자열에서 첫번째 파트
        solve(start+2*newSize,newSize); //3등분한 문자열에서 세번째 파트
    }
}
