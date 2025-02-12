package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashMap<String,Integer> map=new HashMap<>();

        int count=0;
        for(int i=0;i<n;i++){
            String s=br.readLine();
            count++;
            map.put(s,count);
        }

        int cur=0;
        int result=0;

        for(int i=0;i<n;i++){
            String s=br.readLine();
            cur++;

            //출구로 나온 차 순위 != 현재 탐색하는 차 순위
            //현재 순서값(cur)로 업데이트
            int end=map.get(s); //차가 들어갔을 때 순위
            if(end>cur){
                map.put(s,cur);
                result++;
            }

            //cur ~ end까지 실제 순위 업데이트 필요
            //해시에 저장해둔 차 탐색
            for(Map.Entry<String,Integer> entry:map.entrySet()){
                //현재 탐색하고 있는 차의 순위값
                String car=entry.getKey();
                int k=entry.getValue();

                //차가 현재 탐색중인 차와 같고, 순위도 똑같은 차라면 업데이트 필요 x
                if(k==cur && car.equals(s)) continue;

                //업데이트 필요한 순위 범위 안에 있는 차라면 업데이트
                if(k>=cur && k<=end){
                    map.put(car,k+1);
                }
            }

        }

        System.out.println(result);

    }
}
