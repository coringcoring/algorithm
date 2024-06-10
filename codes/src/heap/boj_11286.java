package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //절댓값이 더 크면 바꿈
                if(Math.abs(o1)>Math.abs(o2)){
                    return Math.abs(o1)-Math.abs(o2);
                }else if(Math.abs(o1)==Math.abs(o2)){ //절댓값 같으면 음수가 뒤로 가도록 함
                    return o1-o2;
                }else{
                    return -1;
                }
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            int val=Integer.parseInt(br.readLine());

            if(val!=0){
                pq.offer(val);
            }else{
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
