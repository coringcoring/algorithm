package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(b); // 1 2 3 7 8
        Arrays.sort(a); // 0 1 1 1 6

        for (int i = n - 1; i >= 0; i--) {
            result += a[i] * b[n - 1 - i];
        }

        System.out.println(result);
    }
}
