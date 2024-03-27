package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2961 {
    static int[][] arr;
    static int result=Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n][2];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[i][0]=a;
            arr[i][1]=b;
        }
        dfs(0,1,0,0);
        System.out.println(result);

    }

    public static void dfs(int depth,int s,int b,int cnt){
        if(depth==n){
            if(cnt!=0 && Math.abs(s-b)<result)
                result=Math.abs(s-b);
            return;
        }
        dfs(depth+1,s*arr[depth][0],b+arr[depth][1],cnt+1);
        dfs(depth+1,s,b,cnt);
    }
}
