package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_5800 { //문제 잘못읽어서 시간 날림;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        Integer[][] res=new Integer[k][3]; //결과 저장

        for(int i=0;i<k;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            String[] s=br.readLine().split(" ");
            for(int j=1;j<s.length;j++){
                arr.add(Integer.parseInt(s[j])); //인덱스 1부터 값 넣음
            }
            Collections.sort(arr,Collections.reverseOrder());

            int gap=Integer.MIN_VALUE;
            for(int t=0;t<arr.size()-1;t++){
                gap=Math.max(arr.get(t)-arr.get(t+1),gap);
            }

            res[i][0]=arr.get(0); //max
            res[i][1]=arr.get(arr.size()-1);//min
            res[i][2]=gap;
        }
        for(int i=0;i<k;i++){
            System.out.println("Class "+(int)(i+1));
            System.out.println("Max "+res[i][0]+", Min "+res[i][1]+
                    ", Largest gap "+res[i][2]);
        }

    }
}
