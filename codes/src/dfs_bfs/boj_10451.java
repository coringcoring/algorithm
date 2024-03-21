package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10451 {
    static int t;
    static int[] arr;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int res=0;
            int n=Integer.parseInt(br.readLine());
            arr=new int[n+1];
            chk=new boolean[n+1];
            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int j=1;j<=n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            for(int k=1;k<=n;k++){
                if(!chk[k]){
                    dfs(k);
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static void dfs(int start){ //재귀로 구현
        chk[start]=true;
        int p=arr[start];
        if(!chk[p]){
            dfs(arr[start]);
        }
    }
}
