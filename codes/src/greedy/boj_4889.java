package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num=0;

        while(true){
            String s=br.readLine();
            if(s.contains("-")) break;
            num++;
            char[] arr=s.toCharArray();

            int n=arr.length;

            //안정적인 문자열로 바꾸는데 필요한 최소 연산의 수 저장
            int count=0;

            Stack<Character> stack=new Stack<>();

            for(int i=0;i<n;i++){
                char cur=arr[i];
                if(cur=='{'){
                    stack.push(cur);
                }
                else{ //'}' 인 경우
                    if(stack.isEmpty()){
                        count++;
                        stack.push('{');
                    }else{
                        stack.pop();
                    }
                }
            }

            sb.append(num+". "+(count+stack.size()/2)).append("\n");
        }
        System.out.println(sb);
    }
}
