package dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1504 {

    private class Node implements Comparable<Node>{
        int end;
        int weight;

        Node(int end, int weight){
            this.end=end;
            this.weight=weight;
        }

        @Override
        public int compareTo(Node o){
            return weight-o.weight;
        }
    }
    static int N,E;
    static ArrayList<ArrayList<Node>> a;
    static int[] dist;
    static boolean[] check;
    static final int INF=200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

    }
}
