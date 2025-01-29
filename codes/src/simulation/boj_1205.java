package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());

        //N이 0이면 순위는 무조건 1
        //여기에 이 조건문을 두지 않고, 아래에 두면 NPE가 발생하므로 주의
        //이유: N이 0인데 밑에 arr[N][0]에서 값을 조회하려고 하면 아무 값이 없으므로 NPE 발생하는 것
        if(N==0){
            System.out.println(1);
            return; //main 종료
        }

        //점수 + 순위 저장 2차원 배열
        int[][] arr=new int[N+1][2];
        st=new StringTokenizer(br.readLine());
        //점수, 순위 저장
        for(int i=1;i<=N;i++){
            arr[i][0]=Integer.parseInt(st.nextToken());

            if(arr[i-1][0]>arr[i][0]){
                arr[i][1]=i;
            }
            else if(arr[i-1][0]==arr[i][0]){
                arr[i][1]=arr[i-1][1];
            }
        }


        //만약 순위가 다 차고, 들어갈 곳이 없다면
        if(N==P && arr[N][0]>=K){
            System.out.println(-1);
            return; //main 종료
        }

        int rank=1;
        for(int i=1;i<=N;i++){
            if(arr[i][0]>K){
                rank=i+1; //중복 요소 있기 때문에 i+1로 해야함
            }else{
                break;
            }
        }

        System.out.println(rank);
    }
}
