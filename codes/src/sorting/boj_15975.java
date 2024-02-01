package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15975 {
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long answer = 0; //정답 저장

        List<int[]> arr = new ArrayList<>();
        for(int i=0;i<=N;i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            arr.add(new int[]{x, y});
        }

        //팀 정렬(삽입+합병 정렬) 사용
        Collections.sort(arr,(a,b)->{ //x좌표 기준으로 정렬 후 -> 색깔 같은거끼리
           if(a[1]==b[1]){
               return a[0]-b[0];
           }else return a[1] - b[1];
        });




    }
}
