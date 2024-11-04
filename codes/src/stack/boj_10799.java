package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//참고: https://steady-coding.tistory.com/10
public class boj_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        Stack<Character> stack=new Stack<>();

        int res=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
                continue;
            }

            if(c==')'){
                stack.pop();
                //그전에 있던 게 닫힌 괄호 == 레이저를 의미
                if(s.charAt(i-1)=='('){
                    res+=stack.size();
                }
                else{ //그전에 있던 게 열린 괄호 == 레이저가 아닌 막대기
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
