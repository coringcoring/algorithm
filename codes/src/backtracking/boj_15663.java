package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//참고: https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-15663%EB%B2%88-N%EA%B3%BC-M-9-java
public class boj_15663 {
    static int N,M;
    static StringBuilder sb=new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N];
        visit=new boolean[N];
        result=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //정렬 -> 사전순 증가하는 순 출력 위함

        backtrack(0);
        System.out.println(sb);
    }

    private static void backtrack(int depth){
        if(depth==M){
            for(int i: result){
                sb.append(i+" ");
            }
            sb.append('\n');
            return;
        }

        //before: 이전에 탐색한 arr 요소의 숫자
        int before=0;
        for(int i=0;i<N;i++){
            if(!visit[i] && before!=arr[i]){
                visit[i]=true;
                result[depth]=arr[i];
                before=arr[i];
                backtrack(depth+1);
                visit[i]=false;
            }
        }
    }
}
