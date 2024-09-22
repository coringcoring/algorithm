package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int depth=0;

        for(int i=1; i<=3; i++){
            String a=br.readLine();
            if(!isString(a)){
                count=Integer.valueOf(a);
                depth=i;
            }
        }

        switch(depth) {
            case 1:
                count += 3;
                break;
            case 2:
                count += 2;
                break;
            case 3:
                count += 1;
                break;
            default:
                count = 0;
        }

        if(count%3==0){
            if(count%5==0){
                System.out.println("FizzBuzz");
            }
            else{
                System.out.println("Fizz");
            }
        }
        else{
            if(count%5==0){
                System.out.println("Buzz");
            }
            else{
                System.out.println(count);
            }
        }
    }

    private static boolean isString(String a){
        a=a.toUpperCase();
        for(int i=0; i<a.length(); i++){
            int temp=a.charAt(i)-'A';
            if(0<=temp && temp<26){
                return true;
            }
        }
        return false;
    }
}
