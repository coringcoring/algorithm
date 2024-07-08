package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int[] changes={25,10,5,1};

        for(int i=0;i<T;i++){
            int c=Integer.parseInt(br.readLine());
            int[] res=new int[4];
            for(int j=0;j<4;j++){
                res[j]=c/changes[j];
                c%=changes[j];
            }
            for(int ans: res){
                System.out.print(ans+" ");
            }
            System.out.println();
        }
    }
}
