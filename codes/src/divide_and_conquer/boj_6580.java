package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_6580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int n = Integer.parseInt(s1.split(" ")[2]);
        br.readLine(); // n*n이므로 따로 저장x
        br.readLine();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            String[] hex = s.split(",");
            for (int j = 0; j < hex.length; j++) {
                int val = Integer.decode(hex[j]); // 2진수로 변환
                for (int k = 0; k < 8; k++) {
                    // 1<<(7-k) : 1을 왼쪽으로 (7-k)비트만큼 이동시킴
                    // val&(1<<(7-k)): val의 (7-k)가 1인지 확인
                    arr[i][j * 8 + k] = (val & (1 << (7 - k))) != 0 ? 1 : 0;
                }
            }
        }

        br.readLine(); // } 읽기
        System.out.println(n); // n 출력

        System.out.println(Quadtree(arr, 0, 0, n));
    }

    private static String Quadtree(int[][] arr, int x, int y, int size) {
        if (isSameColor(arr, x, y, size)) {
            return arr[x][y] == 1 ? "B" : "W";
        }
        int halfSize = size / 2;
        return "Q" +
                Quadtree(arr, x, y, halfSize) + // 좌상
                Quadtree(arr, x, y + halfSize, halfSize) + // 우상
                Quadtree(arr, x + halfSize, y, halfSize) + // 좌하
                Quadtree(arr, x + halfSize, y + halfSize, halfSize); // 우하

    }

    // 현재 영역이 모두 같은 색인지 확인하는 함수
    private static boolean isSameColor(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[x + i][y + j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}