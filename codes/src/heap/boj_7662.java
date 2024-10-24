package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

//그냥 우선순위큐로 풀면 시간초과 발생
//참고:https://loosie.tistory.com/314

public class boj_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            int k=Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map=new TreeMap<>();

            for(int i=0;i<k;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op=st.nextToken().charAt(0);
                int a=Integer.parseInt(st.nextToken());

                if(op=='I'){
                    map.put(a, map.getOrDefault(a,0)+1);
                }
                else if(op=='D'){
                    //큐가 비어있으면 무시하고 진행
                    if(map.size()==0) continue;

                    int num;
                    if(a==-1){
                        num=map.firstKey();
                    }else{
                        num=map.lastKey();
                    }

                    //map.put을 하면 이전의값이 리턴됨
                    //리턴한 값이 1이라는 의미 == 큐에서 모두 삭제됨
                    //따라서 맵에서 remove해야함
                    if(map.put(num,map.get(num)-1)==1){
                        map.remove(num);
                    }
                }
            }

            if(map.size()==0){
                sb.append("EMPTY\n");
            }else{
                sb.append(map.lastKey()+" "+map.firstKey()+"\n");
            }

        }
        System.out.println(sb);
    }
}
