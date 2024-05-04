package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] map=new int[26][26];
        int start,end;

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i!=j) map[i][j]=1000;
            }
        }

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            start=st.nextToken().charAt(0)-'a';
            st.nextToken(); //is
            end=st.nextToken().charAt(0)-'a';
            map[start][end]=1;
        }

        //플로이드 와샬
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                if(i==k) continue;
                for(int j=0;j<26;j++){
                    if(i==j || k==j) continue;
                    map[i][j]= Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }

        int M=Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st2=new StringTokenizer(br.readLine());
            start= st2.nextToken().charAt(0)-'a';
            st2.nextToken();
            end=st2.nextToken().charAt(0)-'a';
            if(map[start][end]!=0 && map[start][end]<1000) System.out.println("T");
            else System.out.println("F");
        }
    }
}
