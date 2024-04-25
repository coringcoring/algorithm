package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        Stack<Integer> stk=new Stack<>(); //스택
        StringBuilder sb=new StringBuilder(); //+ - 저장

        int start=0; //push는 오름차순으로 해야하기 때문에 push한 수를 기억.

        while(n-->0){
            int val=Integer.parseInt(br.readLine());
            if(val>start){
                for(int i=start+1;i<=val;i++){
                    stk.push(i);
                    sb.append('+').append('\n');
                }
                start=val;
            }
            else if(stk.peek()!=val){
                System.out.println("NO");
                return;
            }
            stk.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
