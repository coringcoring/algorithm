package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//참고: https://st-lab.tistory.com/221
//직접 배열을 뒤집는게 아니라, 덱을 사용하여 앞뒤에서 접근할 수 있도록 작성 필요
public class boj_5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t-->0){
            char[] command=br.readLine().toCharArray();
            int n=Integer.parseInt(br.readLine());
            ArrayDeque deque=new ArrayDeque<Integer>();

            String arr=br.readLine();
            String temp=arr.substring(1,arr.length()-1);
            StringTokenizer st=new StringTokenizer(temp,",");

            for(int i=0;i<n;i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            ac(command,deque);
        }
        System.out.println(sb);
    }

    private static void ac(char[] command, ArrayDeque<Integer> deque){
        boolean isRight=true;

        for(char cmd: command){
            if(cmd=='R'){
                isRight=!isRight;
                continue;
            }

            //D함수
            if(isRight){
                if(deque.pollFirst()==null){
                    sb.append("error\n");
                    return;
                }
            }
            else{
                if(deque.pollLast()==null){
                    sb.append("error\n");
                    return;
                }
            }
        }

        //에러가 발생하지 않았다면 무사히 아래함수 실행
        printing(deque,isRight);

    }

    private static void printing(ArrayDeque<Integer> deque,boolean isRight){
        sb.append("[");

        //출력할 원소가 1개 이상인 경우
        if(deque.size()>0){
            if(isRight){
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollFirst());
                }
            }else{
                sb.append(deque.pollLast());

                while(!deque.isEmpty()){
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append("\n");
    }

}
