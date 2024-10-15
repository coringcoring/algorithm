package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//참고: https://velog.io/@ewoo97/BOJ-%EB%B0%B1%EC%A4%80-30804%EB%B2%88-%EA%B3%BC%EC%9D%BC-%ED%83%95%ED%9B%84%EB%A3%A8-JAVA
public class boj_30804 {
    // 2종류 과일의 가장 긴 연속 부분 수열 찾기 문제
    // 부분 수열의 길이가 최대여야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        HashMap<Integer,Integer> count=new HashMap<>();
        int max=0;
        int left=0;

        for(int right=0;right<N;right++){
            count.put(arr[right],count.getOrDefault(arr[right],0)+1);

            while(count.size()>2){
                count.put(arr[left],count.get(arr[left])-1);
                if(count.get(arr[left])==0){
                    count.remove(arr[left]);
                }
                left++;
            }

            max=Math.max(max,right-left+1);
        }

        System.out.println(max);
    }
}
