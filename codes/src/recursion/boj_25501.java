package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_25501 {
    static int rCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String s=br.readLine();
            rCount=0;
            int result= isPalindrome(s);
            System.out.println(result+" "+rCount);
        }
    }

    private static int isPalindrome(String s){
        return recursion(s,0,s.length()-1);
    }

    private static int recursion(String s,int l, int r){
        rCount++;
        if(l>=r) return 1;
        else if(s.charAt(l)!=s.charAt(r)) return 0;
        else return recursion(s,l+1,r-1);
    }
}
