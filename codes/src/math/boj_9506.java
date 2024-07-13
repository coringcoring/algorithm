package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        while(true){
            int N=Integer.parseInt(br.readLine());
            if(N==-1){
                break;
            }
            ArrayList<Integer> lst=new ArrayList<>();
            int sum=0;

            for(int i=1;i<N;i++){
                if(N%i==0){
                    lst.add(i);
                    sum+=i;
                }
            }
            sb.append(N);
            if(N==sum){
                sb.append(" = ");
                for(int i=0;i<lst.size()-1;i++){
                    sb.append(lst.get(i)+" + ");
                }
                sb.append(lst.get(lst.size()-1));
            }else{
                sb.append(" is NOT perfect.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
