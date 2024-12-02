package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-->0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());

            // 각도 정규화 (360도를 넘어가는 경우 처리)
            d = ((d % 360) + 360) % 360;
            // 회전 횟수 계산
            int rotateCount = d / 45;

            int[][] arr=new int[n][n];
            int[][] result=new int[n][n];

            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    result[i][j]=arr[i][j];
                }
            }

            // rotateCount만큼 회전 수행
            for (int rotate = 0; rotate < Math.abs(rotateCount); rotate++) {
                arr = rotateArray(arr, n, d > 0);
            }

            // 결과 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    private static int[][] rotateArray(int[][] arr, int n, boolean clockwise) {
        int[][] result = new int[n][n];
        int mid = n / 2;

        // 원본 배열 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = arr[i][j];
            }
        }

        if (clockwise) {
            // 주대각선 → 가운데 열
            for (int i = 0; i < n; i++) {
                result[i][mid] = arr[i][i];
            }

            // 가운데 열 → 부대각선
            for (int i = 0; i < n; i++) {
                result[i][n-1-i] = arr[i][mid];
            }

            // 부대각선 → 가운데 행
            for (int i = 0; i < n; i++) {
                result[mid][i] = arr[n-1-i][i];
            }

            // 가운데 행 → 주대각선
            for (int i = 0; i < n; i++) {
                result[i][i] = arr[mid][i];
            }
        } else {
            // 주대각선 → 가운데 행
            for (int i = 0; i < n; i++) {
                result[mid][i] = arr[i][i];
            }

            // 가운데 행 → 부대각선
            for (int i = 0; i < n; i++) {
                result[i][n-1-i] = arr[mid][i];
            }

            // 부대각선 → 가운데 열
            for (int i = 0; i < n; i++) {
                result[i][mid] = arr[i][n-1-i];
            }

            // 가운데 열 → 주대각선
            for (int i = 0; i < n; i++) {
                result[i][i] = arr[i][mid];
            }
        }

        return result;
    }
}
