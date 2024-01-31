package sorting;

import java.io.*;
import java.util.Arrays;

public class boj_11651 {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];

        for(int i=0;i<N;i++){
            String[] s=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(s[1]);
            arr[i][1]=Integer.parseInt(s[0]);
        }

        //두번째 원소를 기준으로 오름차순 정렬 -> 두번째 원소가 같을 경우 첫번째 원소를 오름차순으로
        // Comparator 메소드 사용: https://st-lab.tistory.com/243 해당 블로그 참고

        Arrays.sort(arr,(a, b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            else{
                return a[0]-b[0];
            }
        });

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i][1]+" "+arr[i][0]).append('\n');
        }
        System.out.println(sb);


        br.close();



    }
}
