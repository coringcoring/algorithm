package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //reverseOrder()를 통해 내림차순 정렬 -> max heap이므로
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            int val=Integer.parseInt(br.readLine());
            if(val==0){
                if(queue.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(queue.poll()).append("\n");
                }
            }else{
                queue.offer(val); //add 사용해도 됨. 둘은 예외를 발생시키느냐 아니냐의 차이
            }
        }
        System.out.println(sb);
    }
}
