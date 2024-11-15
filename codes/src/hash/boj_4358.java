package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map=new HashMap<>();
        String s;
        int total=0;

        while((s=br.readLine())!=null){
            total++;
            map.put(s,map.getOrDefault(s,0)+1);
        }

        List<String> list=new ArrayList<>();
        for(HashMap.Entry<String,Integer> entry:map.entrySet()){
            String tree=entry.getKey();
            list.add(tree);
        }
        Collections.sort(list);

        for(String tree:list){
            int count=map.get(tree);
            System.out.println(tree+" "+String.format("%.4f",(double)(count*100)/(double)total));
        }

    }
}
