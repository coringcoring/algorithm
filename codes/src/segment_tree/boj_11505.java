package segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11505 {
    static int N,M,K;
    static long[] arr,tree;
    static long MOD=1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        arr=new long[N+1];

        for(int i=1;i<=N;i++){
            arr[i]=Long.parseLong(br.readLine());
        }

        tree=new long[N*4];
        init(1,N,1);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M+K;i++){
            st=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            if(a==1){
                arr[b]=c;
                update(1,N,1,b,c);
            }else if(a==2){
                sb.append(mul(1,N,1,b,c)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static long init(int start,int end, int node){
        if(start==end){
            return tree[node]=arr[start];
        }

        int mid=(start+end)/2;

        //재귀적으로 두부분을 나눔 -> 그 곱을 자기 자신으로 함
        return tree[node]=(init(start,mid,node*2)*init(mid+1,end,node*2+1))%MOD;
    }

    private static long mul(int start,int end,int node,int left,int right){
        if(left>end || right<start){
            return 1;
        }
        if(left<=start && end<=right){
            return tree[node];
        }
        int mid=(start+end)/2;
        return (mul(start,mid,node*2,left,right)*mul(mid+1,end,node*2+1,left,right))%MOD;
    }

    private static long update(int start,int end,int node,int idx,long val){
        //값을 변경했으므로.. 구간 곱을 update해주어야함 (값이 변경된 부분과 관련있는 것들만 update)

        //범위 밖이면 갱신할 필요x
        if(idx<start || idx>end){
            return tree[node];
        }
        if(start==end){
            return tree[node]=val;
        }

        int mid=(start+end)/2;
        return tree[node]=(update(start,mid,node*2,idx,val)*update(mid+1,end,node*2+1,idx,val))%MOD;
    }


}
