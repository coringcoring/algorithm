package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889 {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visit=new boolean[N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        combination(0,0);
        System.out.println(min);

    }

    //dfs 백트래킹을 하며 조합 탐색
    private static void combination(int index,int depth){
        if(depth==N/2){
            int start=0;
            int link=0;

            for(int i=0;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    if(visit[i]==true && visit[j]==true){
                        start+=arr[i][j];
                        start+=arr[j][i];
                    }
                    else if(visit[i]==false && visit[j]==false){
                        link+=arr[i][j];
                        link+=arr[j][i];
                    }
                }
            }

            int diff=Math.abs(start-link);
            if(diff==0){
                System.out.println(diff);
                System.exit(0);
            }
            min=Math.min(diff,min);

            return;
        }

        for(int i=index;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                //if 재귀 호출 시 i+1이 아닌 i로 해도 똑같은 출력 결과
                //i를 하면 모든 순서 조합을 찾음 (1,2), (2,1) 을 다 탐색함
                //i+1을 하면 오름차순 순서 조합(중복x) 을 찾음 (1,2)만 찾고 (2,1)은 안 찾음
                combination(i+1,depth+1);
                visit[i]=false;
            }
        }

    }
}
