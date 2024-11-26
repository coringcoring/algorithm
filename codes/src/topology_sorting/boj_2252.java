package topology_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        //진입 차수 업데이트
        int[] in_degree=new int[N+1];
        List<List<Integer>> arr=new ArrayList<>();

        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            in_degree[b]++;
        }

        Queue<Integer> q=new LinkedList<>();

        //진입차수가 0인 노드들을 큐에 넣기
        for(int i=1;i<=N;i++){
            if(in_degree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur=q.poll();
            sb.append(cur+" ");

            for(int j=0;j<arr.get(cur).size();j++){
                int nxt=arr.get(cur).get(j);
                in_degree[nxt]--;

                if(in_degree[nxt]==0){
                    q.offer(nxt);
                }
            }
        }
        System.out.println(sb);
    }
}
