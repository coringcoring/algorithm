package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16953 {
    static long A,B;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int res=solve();
        System.out.println(res);
        br.close();
    }

    private static int solve(){
        Queue<Long> q = new LinkedList<>();

        q.add(A);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                long tmp=q.poll();
                if(tmp==B){
                    count++;
                    return count;
                }

                if(tmp*2<=B){
                    q.add(tmp*2);
                }
                if(tmp*10+1<=B){
                    q.add(tmp*10+1);
                }
            }
            count++;
        }

        return -1;
    }
}
