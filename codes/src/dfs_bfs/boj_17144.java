package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17144 {
    static int R,C,T;
    static int[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    //공기 청정기 위치
    static int airCleanerTop = -1;
    static int airCleanerBottom = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        arr=new int[R][C];

        for(int i=0;i<R;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    if (airCleanerTop == -1) airCleanerTop = i;
                    else airCleanerBottom = i;
                }

            }
        }

        // T초 동안 시뮬레이션
        for (int t = 0; t < T; t++) {
            spread();
            operate();
        }

        // 남은 미세먼지의 양 계산
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) result += arr[i][j];
            }
        }
        System.out.println(result);
    }
    private static void spread(){
        int[][] temp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    int amount = arr[i][j] / 5;
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && arr[nx][ny] != -1) {
                            temp[nx][ny] += amount;
                            count++;
                        }
                    }
                    temp[i][j] += arr[i][j] - (amount * count);
                }
            }
        }

        // 공기청정기 위치 복원
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1) temp[i][j] = -1;
                arr[i][j] = temp[i][j];
            }
        }
    }

    private static void operate(){
        // 위쪽 공기청정기
        for (int i = airCleanerTop - 1; i > 0; i--) {
            arr[i][0] = arr[i-1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            arr[0][j] = arr[0][j+1];
        }
        for (int i = 0; i < airCleanerTop; i++) {
            arr[i][C-1] = arr[i+1][C-1];
        }
        for (int j = C - 1; j > 1; j--) {
            arr[airCleanerTop][j] = arr[airCleanerTop][j-1];
        }
        arr[airCleanerTop][1] = 0;

        // 아래쪽 공기청정기
        for (int i = airCleanerBottom + 1; i < R - 1; i++) {
            arr[i][0] = arr[i+1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            arr[R-1][j] = arr[R-1][j+1];
        }
        for (int i = R - 1; i > airCleanerBottom; i--) {
            arr[i][C-1] = arr[i-1][C-1];
        }
        for (int j = C - 1; j > 1; j--) {
            arr[airCleanerBottom][j] = arr[airCleanerBottom][j-1];
        }
        arr[airCleanerBottom][1] = 0;
    }
}
