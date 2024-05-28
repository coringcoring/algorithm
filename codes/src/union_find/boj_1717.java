package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1717 {
    static int N,M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        for(int i=0;i<N+1;i++){ //부모 정보 초기화
            parent[i]=i;
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int ch=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if(ch==0){
                //합집합 union
                union(a,b);
            }
            else{
                //확인
                if(find(a)==find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    public static int find(int x){//x의 부모를 찾는 메소드
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public static void union(int x,int y){
        //union: y의 부모를 x의 부모로 치환
        x=find(x);
        y=find(y);
        if(x!=y){
            if(x<y){
                parent[y]=x;
            }else{
                parent[x]=y;
            }
        }
    }
}
