package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        Stack<String> stk=new Stack<>();

        for(int i=0;i<n;i++){
            String[] s=br.readLine().split(" ");
            for(int j=0;j<s.length;j++){
                stk.push(s[j]);
            }
            sb.append("Case #"+(i+1)+": ");
            for(int j=0;j<s.length;j++){
                sb.append(stk.pop()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
