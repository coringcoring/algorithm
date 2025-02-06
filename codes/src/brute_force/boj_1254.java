package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();

        int len=s.length();
        int i=0;

        while(true){
            if(isPalindrome(s)){
                System.out.println(s.length());
                break;
            }
            s=s.substring(0,len)+s.charAt(i)+s.substring(len);

            i++;
        }
    }

    private static boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
