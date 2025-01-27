package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] info=new int[N];
        int[] arr=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            info[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int M=Integer.parseInt(br.readLine());
        int[] x=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            x[i]=Integer.parseInt(st.nextToken());
        }

        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            //queue라면
            if(info[i]==0){
                q.addFirst(arr[i]);
            }
            //스택인 경우, 아무일도 일어나지 않으므로
        }

        for(int i=0;i<M;i++){
            q.add(x[i]);
            sb.append(q.pollFirst()+" ");
        }

        System.out.println(sb);
    }
}
