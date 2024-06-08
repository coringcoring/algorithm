package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        HashMap<String, String> map=new HashMap<String,String>();
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            String act=st.nextToken();

            if(map.containsKey(name)){
                map.remove(name);
            }else{
                map.put(name,act);
            }
        }
        ArrayList<String> lst=new ArrayList<String>(map.keySet());
        Collections.sort(lst,Collections.reverseOrder());
        for(String ll: lst){
            System.out.println(ll);
        }
    }
}
