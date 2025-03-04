package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복 가능, 비내림차순(=오름차순) 수열
public class boj_15666 {
    static int N,M;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr=new int[N];
        visit=new boolean[N];
        result=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtrack(0,0);
        System.out.println(sb);
        br.close();
    }

    private static void backtrack(int start, int depth){
        if(depth==M){
            for(int k: result){
                sb.append(k+" ");
            }
            sb.append("\n");
            return;
        }

        int before=0;
        for(int i=start;i<N;i++){
            if(before!=arr[i]){//중복 스킵
                result[depth]=arr[i];
                before=arr[i];
                backtrack(i,depth+1);
            }
        }
    }
}
