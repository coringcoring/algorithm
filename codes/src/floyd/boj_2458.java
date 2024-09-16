package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[N][N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            visit[a][b] = true;
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visit[i][k] && visit[k][j]) {
                        visit[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visit[i][j] || visit[j][i]) {
                    cnt[i] ++;
                }
            }
        }

        int res =0;
        for(int num : cnt) {
            if(num == N-1) res++;
        }
        System.out.println(res);

    }
}
