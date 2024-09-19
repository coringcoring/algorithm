package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15654 {
    static int N,M;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        visit=new boolean[N];
        result=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); //오름차순 정렬 후 dfs
        dfs(0,0);

        System.out.println(sb);
    }

    private static void dfs(int start,int depth){
        if (depth==M){
            for(int i=0;i<M;i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                result[depth]=arr[i];
                dfs(start,depth+1);
                visit[i]=false;
            }
        }
    }
}
