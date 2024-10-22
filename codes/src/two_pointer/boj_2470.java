package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//참고: https://velog.io/@richsubin/%EB%B0%B1%EC%A4%80-2470%EB%B2%88-%EB%91%90-%EC%9A%A9%EC%95%A1-JAVA
public class boj_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ans1=0;
        int ans2=0;
        int chk=Integer.MAX_VALUE; //max value로 초기화

        int low=0; //start 포인터
        int high=n-1; //end 포인터
        while(low<high){
            int sum=arr[low]+arr[high];

            //절댓값 씌움 -> 최소값이 0이 됨
            if(Math.abs(sum)<chk){
                chk=Math.abs(sum);
                ans1=arr[low];
                ans2=arr[high];
            }

            //음수값과 양수값의 절댓값 차이가 작을수록 0에 가까움
            if(sum<0){ //음수 절댓값이 더 큰 경우 -> 음수 절댓값을 줄여야함
                low++;
            }else{ //양수 절댓값이 더 큰 경우 -> 양수 절댓값 줄여야함
                high--;
            }
        }
        System.out.println(ans1+" "+ans2);
    }
}
