package heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //max heap
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int val=Integer.parseInt(st.nextToken());
            if(val==0){
                if(pq.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(pq.poll());
                }
            }
            else{
                for(int j=0;j<val;j++) {
                    int a = Integer.parseInt(st.nextToken());
                    pq.add(a);
                }
            }
        }

    }
}
