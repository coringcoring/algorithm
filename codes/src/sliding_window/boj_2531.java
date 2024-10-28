package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//투 포인터로도 풀 수 있음
//참고: https://buddev.tistory.com/43
public class boj_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());

        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int[] visit=new int[d+1];
        int total=0; //현재 먹은 초밥 개수
        int max;
        for(int i=0;i<k;i++){
            if(visit[arr[i]]==0){//방문하지 않은 초밥
                total++;
            }
            visit[arr[i]]++;
        }
        if(visit[c]==0){
            max=total+1;
        }else{
            max=total;
        }

        for(int i=1;i<N;i++){
            visit[arr[i-1]]--; //이전 초밥은 빼줌
            //이전 초밥을 빼주었을때 visit가 0이 되면 == 현재 먹은 초밥 개수에서 빼주어야함
            if(visit[arr[i-1]]==0) total--;

            //다음 초밥을 먹을때 방문한 적 없는 초밥인 경우 총 초밥 (종류) 개수를 +1
            if(visit[arr[(i+k-1)%N]]==0) total++;
            //다음 초밥은 방문 처리 +1
            visit[arr[(i+k-1)%N]]++;

            //마지막 윈도우까지 체크하도록 하기 위해 매 윈도우마다 최댓값이 갱신되도록함
            int cur=total;
            if(visit[c]==0){
                cur++;
            }
            max=Math.max(max,cur);
        }

        System.out.println(max);

    }
}
