package brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class boj_19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for(int i = -999; i <= 999; i++) {
            for(int j = -999; j <= 999; j++) {
                if(a*i + b*j  == c){ // ax + by 가 C이고(x = i, y = j)
                    if(d*i + e*j  == f) { // dx + ey가 f일 때(x = i, y = j)
                        bw.write(i + " " + j + "\n");
                        break;
                    }
                }
            }
        }
        bw.flush();
    }
}
