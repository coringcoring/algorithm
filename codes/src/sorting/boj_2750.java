package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());//배열 크기 입력받음
        int[] arr=new int[N]; //배열 생성

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        //선택 정렬 사용
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }

        //출력
        for(int val: arr){
            System.out.println(val);
        }

    }
}
