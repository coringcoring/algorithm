package union_find;

import java.io.*;
import java.util.StringTokenizer;

public class boj_24391 {
    static int N,M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        parents=new int[N+1];
        for(int i=0;i<N+1;i++){
            parents[i]=i;
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            union(a,b);
        }

        st=new StringTokenizer(br.readLine());
        int[] route=new int[N];
        for(int i=0;i<N;i++){
            int n=Integer.parseInt(st.nextToken());
            route[i]=n;
        }

        int cnt=0;
        for(int i=0;i<N-1;i++){
            //부모가 같지 않다 == 서로 다른 집합이다 == 나가야한다
            if(find(route[i])!=find(route[i+1])) cnt++;
        }
        bw.write(cnt+"");
        bw.close();
        br.close();
    }

    public static int find(int x){
        if(parents[x]==x){
            return x;
        }
        return parents[x]=find(parents[x]);
    }

    public static void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(a>b){
                parents[a]=b;
            }else{
                parents[b]=a;
            }
        }
    }
}
