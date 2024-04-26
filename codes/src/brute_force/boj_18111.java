package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        //입력
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int[][] arr=new int[n][m];
        int min_time=Integer.MAX_VALUE;
        int max_height=0;
        int min=256;
        int max=0;

        for(int i=0;i<n;i++){
            StringTokenizer st2=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st2.nextToken());
                if(arr[i][j]<min) min=arr[i][j];
                if(arr[i][j]>max) max=arr[i][j];
            }
        }
        for(int i=min;i<=max;i++){
            int time=0; //걸린 시간
            int blocks=b;
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(arr[j][k]<i){//현재 높이보다 작으면 채워야함
                        time+=i-arr[j][k];
                        blocks-=i-arr[j][k]; //인벤토리 블록 감소
                    }else if(arr[j][k]>i){ //현재 높이보다 크면 제거해야함
                        time+=(arr[j][k]-i)*2;
                        blocks+=arr[j][k]-i; //인벤토리 블록 증가
                    }
                }
            }
            if(blocks<0) break; //블록 수가 음수가 되면 반복문 종료
            if(time<=min_time && i>=max_height){
                min_time=time;
                max_height=i;
            }
        }


        System.out.println(min_time+" "+max_height);
    }
}
