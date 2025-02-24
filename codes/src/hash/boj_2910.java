package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//참고: https://propercoding.tistory.com/302
public class boj_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> lst=new ArrayList<>();
        List<Integer> original=new ArrayList<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int k=Integer.parseInt(st.nextToken());
            lst.add(k);
            original.add(k);
            map.put(k,map.getOrDefault(k,0)+1);
        }

        Collections.sort(lst,(o1,o2)->{
           if(map.get(o1)==map.get(o2)){//빈도수가 같으면 원래 입력순서로
               return original.indexOf(o1)-original.indexOf(o2);
           }else{ //빈도수가 다르면 높은 순으로
               return Integer.compare(map.get(o2),map.get(o1));
           }
        });

        for(int i=0;i<N;i++){
            System.out.print(lst.get(i)+" ");
        }
    }
}
