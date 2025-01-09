package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고: https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-20922-%EA%B2%B9%EC%B9%98%EB%8A%94-%EA%B1%B4-%EC%8B%AB%EC%96%B4-Java%EC%9E%90%EB%B0%94
public class boj_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] arr=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //원소는 100,000까지의 범위이므로
        //각 원소의 개수를 세는 배열
        int[] count=new int[100001];
        int low=0;
        int high=0;
        int res=-1;

        while(low<=high && high<N){
            //늘릴수 있을때까지 high 포인터 이동 & 길이 늘리기
            while(high<N && count[arr[high]]+1<=K){
                count[arr[high++]]++;
            }
            //길이 구하기
            int len=high-low;
            //길이 업데이트 (최댓값 업데이트)
            res=Math.max(res,len);

            //low 포인터 이동 & 포인터 이동에 따른 count 개수 감소
            count[arr[low++]]--;
        }
        System.out.println(res);
    }
}
