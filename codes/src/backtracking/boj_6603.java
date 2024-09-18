package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603 {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());

            N=Integer.parseInt(st.nextToken());
            if(N==0){
                break;
            }

            arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            result=new int[6];
            visit=new boolean[N];
            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int start, int depth){
        if(depth==6){
            for(int val: result){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                result[depth]=arr[i];
                dfs(i,depth+1);
                visit[i]=false;
            }
        }
    }
}
