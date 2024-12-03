package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//참고: https://st-lab.tistory.com/139
public class boj_9251 {
    static char[] str1;
    static char[] str2;

    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        str1=br.readLine().toCharArray();
        str2=br.readLine().toCharArray();

        dp=new Integer[str1.length][str2.length];

        System.out.println(LCS(str1.length-1,str2.length-1));
    }

    private static int LCS(int x, int y){
        //인덱스 밖인 경우 0
        if(x==-1 || y==-1) return 0;

        //아직 탐색하지 않은 인덱스
        if(dp[x][y]==null){
            dp[x][y]=0;

            //str1의 x번째 원소값과 str2의 y번째 원소값을 비교함
            if(str1[x]==str2[y]){
                //같으면 이전 x-1, y-1의 값에서 +1
                dp[x][y]=LCS(x-1,y-1)+1;
            }
            else{
                //같지 않으면 x-1,y 나 x,y-1 중에 큰거 가져오기
                dp[x][y]=Math.max(LCS(x-1,y),LCS(x,y-1));
            }
        }
        return dp[x][y];
    }
}
