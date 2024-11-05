package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command=st.nextToken();

            if(command.equals("push")){
                queue.offer(Integer.parseInt(st.nextToken()));
            }else if(command.equals("pop")){
                Integer tmp=queue.poll();
                if(tmp==null){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(tmp).append("\n");
                }
            }else if(command.equals("size")){
                sb.append(queue.size()).append("\n");
            }else if(command.equals("empty")){
                if(!queue.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(1).append("\n");
                }
            }else if(command.equals("front")){
                Integer tmp=queue.peek();
                if(tmp==null){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(tmp).append("\n");
                }
            }else if(command.equals("back")){
                Integer tmp=queue.peekLast();
                if(tmp==null){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(tmp).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
