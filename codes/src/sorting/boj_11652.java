package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        //hash map 사용
        HashMap<Long,Integer> hm=new HashMap<>();

        int max=0;
        long x=0;
        for(int i=0;i<N;i++){
            long card=Long.parseLong(br.readLine());
            //getOrDefault함수: 해당 key가 존재하지 않으면 default로 0을 반환
            hm.put(card,hm.getOrDefault(card,0)+1);
            if(hm.get(card)>max){
                max=hm.get(card);
                x=card;
            }
            else if(hm.get(card)==max){
                //가장 많이 가지고 있는 정수가 여러가지면 작은 것 출력
                x=Math.min(x,card);
            }
        }
        System.out.println(x);
    }
}
