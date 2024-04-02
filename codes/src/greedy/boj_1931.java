package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[][] arr=new int[n][2];
        int result=0;

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");

            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        //아.. compartor을 쓰는건 알겠는데 까먹었다..
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) { //종료 시간이 같으면
                    return o1[0] - o2[0]; //시작 시간 기준으로
                }

                return o1[1] - o2[1];//종료 시간 기준으로
            }
        });

        int end=0;

        for(int i=0;i<n;i++){
            if(end<=arr[i][0]){
                end=arr[i][1];
                result++;
            }
        }
        System.out.println(result);
    }
}
