package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack<>();
        int count=1;
        String[] arr=br.readLine().split(" ");

        for(int i=0;i<n;i++){
            int temp=Integer.parseInt(arr[i]);
            if(temp!=count){
                //현재줄 맨 앞과 스택 맨앞 비교
                if(!stack.isEmpty() && count==stack.peek()){
                    count++;
                    stack.pop();
                    i--;
                    //현재 사람 건너뛰고 스택 top 확인시 사용 (반복문 처음 시점으로 돌아감)
                    //처음 시점으로 돌아가서 현재 사람에 대해서 처리
                }else{
                    stack.push(temp);
                }
            }else{
                count++;
            }
        }

        String result="Nice";

        while(!stack.isEmpty()){
            int temp=stack.pop();
            if(temp==count){
                count++;
            }else{
                result="Sad";
                break;
            }
        }
        System.out.println(result);
    }
}
