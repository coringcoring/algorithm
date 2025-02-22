package stack;

import java.io.*;
import java.util.Stack;

public class boj_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            Stack<Character> left=new Stack<>();//커서 왼쪽에 있는 문자들을 저장
            Stack<Character> right=new Stack<>();//커서 오른쪽에 있는 문자들을 저장

            char[] s=br.readLine().toCharArray();

            for(int i=0;i<s.length;i++){
                if(s[i]=='<'){
                    if(!left.isEmpty()){
                        right.push(left.pop());
                    }
                }else if(s[i]=='>'){
                    if(!right.isEmpty()){
                        left.push(right.pop());
                    }
                }
                else if(s[i]=='-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                }else{
                    left.push(s[i]);
                }
            }

            StringBuilder result=new StringBuilder();
            while(!left.isEmpty()){
                result.append(left.pop());
            }
            result.reverse();
            while(!right.isEmpty()){
                result.append(right.pop());
            }
            sb.append(result.toString()+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
