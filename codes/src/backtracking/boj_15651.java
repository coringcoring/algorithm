package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class boj_15651 {
    static int N;
    static int M;
    static int[] arr;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+1];

        dfs(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth){
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
