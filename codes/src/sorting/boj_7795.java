package sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int[] A=new int[N];
            int[] B=new int[M];

            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[j]=Integer.parseInt(st.nextToken());
            }
            //8 1 7 3 1
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                B[j]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B); //1 2 3 5 6

            int res=0;
            for(int j=0;j<N;j++){//A 배열 크기만큼 돌기
                int first=0;
                int end=M-1; //B 배열을 탐색
                int idx=0;

                while(first<=end){
                    int mid=(first+end)/2;
                    if(B[mid]<A[j]){//현재 A배열의 요소보다 작다면
                        first=mid+1;
                        idx=mid+1;
                    }
                    else{
                        end=mid-1;
                    }
                }
                res+=idx;
            }
            bw.write(Integer.toString(res)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
