package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int sum=0;
        for(int i=0;i<X;i++){
            sum+=arr[i];
        }

        int max=sum;
        int maxCnt=1;

        for(int i=X;i<N;i++){
            //이전껄 빼고 새로운걸 더함
            sum=sum-arr[i-X]+arr[i];
            if(sum==max){
                maxCnt++;
            }else if(sum>max){ //최댓값 갱신 -> maxCnt도 초기화해야함
                max=sum;
                maxCnt=1;
            }
        }

        if(max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(maxCnt);
        }
    }
}
