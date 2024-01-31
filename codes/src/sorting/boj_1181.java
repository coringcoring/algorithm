package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj_1181 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());
        String arr[]=new String[N];
        for(int i=0;i<N;i++){
            arr[i]=br.readLine();
        }

        //똑같이 Comparator 응용 (공부 더 필요.........)
        Arrays.sort(arr,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                } else{
                    return o1.length()-o2.length();
                }
            }
        });

        sb.append(arr[0]).append("\n");

        for(int i=1;i<arr.length;i++){
            if(!arr[i].equals(arr[i-1])){//중복인지
                sb.append(arr[i]).append("\n");
            }
        }

        System.out.println(sb);

    }
}
