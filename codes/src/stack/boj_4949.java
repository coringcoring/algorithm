package stack;

import java.io.*;
import java.util.Stack;

public class boj_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String s=br.readLine();
            String answer="yes";
            if(s.equals(".")){
                break;
            }
            Stack<Character> stack=new Stack<>();
            char[] sc=s.toCharArray();
            for(char c: sc){
                if(c=='(' || c=='['){
                    stack.add(c);
                }
                else if(c==')'){
                    if(stack.isEmpty()||stack.peek()!='('){
                        answer="no";
                    }
                    else{
                        stack.pop();
                    }
                }
                else if(c==']'){
                    if(stack.isEmpty()||stack.peek()!='['){
                        answer="no";
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                answer="no";
            }
            bw.write(answer+"\n");
            bw.flush();
        }
        bw.close();
    }
}
