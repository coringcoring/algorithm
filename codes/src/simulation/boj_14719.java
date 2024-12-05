package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참고: https://tussle.tistory.com/979
public class boj_14719 {
    static int H,W;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());

        arr=new int[W];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //빗물이 고이는 총량
        int result=0;

        for(int i=1;i<W-1;i++){
            int left=0;
            int right=0;

            //왼쪽 블럭의 최대 높이를 구하기
            for(int j=0;j<i;j++){
                left=Math.max(left,arr[j]);
            }
            //오른쪽 블럭의 최대 높이 구하기
            for(int j=i+1;j<W;j++){
                right=Math.max(right,arr[j]);
            }

            //왼쪽 최대 높이, 오른쪽 최대높이보다 현재 열의 높이가 작을때
            //왼쪽 오른쪽 최대높이의 최솟값에서 현재 열의 높이를 뺀만큼 물이 고이게 됨
            if(arr[i]<left && arr[i]<right){
                result+=Math.min(left,right)-arr[i];
            }
        }

        System.out.println(result);
    }

}
