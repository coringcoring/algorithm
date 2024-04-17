package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
    static int N,R,C,size,res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        size=(int)Math.pow(2,N);
        find(0,0,size);
    }
    public static void find(int r, int c, int size){
        if(size==1){
            System.out.println(res);
            return;
        }
        int newSize=size/2;
        if(r+newSize>R && c+newSize>C){
            find(r,c,newSize);
        }
        if(r+newSize>R && c+newSize<=C){
            res+=(size*size)/4;
            find(r,c+newSize,newSize);
        }
        if(r+newSize<=R && c+newSize>C){
            res+=((size*size)/4)*2;
            find(r+newSize,c,newSize);
        }
        if(r+newSize<=R && c+newSize<=C){
            res+=((size*size)/4)*3;
            find(r+newSize,c+newSize,newSize);
        }
    }
}
