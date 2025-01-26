package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//참고: https://bono039.tistory.com/966
public class boj_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        Deque<int[]> deq=new ArrayDeque<>();

        for(int i=1;i<=N;i++){
            int val=Integer.parseInt(st.nextToken());
            deq.add(new int[]{i,val}); //[인덱스, 종이값]
        }

        while(!deq.isEmpty()){
            sb.append(deq.getFirst()[0]+" ");
            int move=deq.poll()[1];

            //마지막 풍선 터뜨린 후 종료해서 빠져나와야함 -> 안그러면 Null pointer exception
            if(deq.isEmpty()) break;

            if(move>0){//양수인 경우
                for(int i=0;i<move-1;i++){
                    deq.addLast(deq.pollFirst());
                }
            }else{//음수인 경우
                for(int i=0;i<Math.abs(move);i++){
                    deq.addFirst(deq.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}
