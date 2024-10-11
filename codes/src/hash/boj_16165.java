package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, List<String>> map=new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            String group=br.readLine();
            int k=Integer.parseInt(br.readLine());
            List<String> list=new ArrayList<>();
            for(int j=0;j<k;j++){
                list.add(br.readLine());
            }
            map.put(group,list);
        }

        for(int i=0;i<M;i++){
            String name=br.readLine();
            int type=Integer.parseInt(br.readLine());
            if(type==1){
                for(String group:map.keySet()){ //모든 팀들을 순회함
                    if(map.get(group).contains(name)){
                        sb.append(group+"\n");
                        break;
                    }
                }
            }else{
                List<String> list=map.get(name);
                Collections.sort(list);
                for(String member:list){
                    sb.append(member+"\n");
                }
            }
        }

        System.out.println(sb);
    }
}
