package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//내가 놓친 부분: 탐색하면서 분기 위로 다시 올라갈때, 이전 탐색에서 방문했던 위치는 초기화해야함!!!
//내가 놓친 부분2: 현재 탐색 위치(x,y)를 방문처리하고, cost(현재 계산하는 땅값)도 현재위치의 값을 업데이트 시켜줘야함!!!
public class boj_14620 {
    static int N;
    static int[][] arr; //화단 지점당 가격 저장하는 이차원 배열
    static int[][] visit;
    static int price=Integer.MAX_VALUE; //최소비용 저장

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        arr=new int[N][N];
        visit=new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(price);
    }

    private static void dfs(int count,int sum){
        if(count==3){
            price=Math.min(price,sum);
            return;
        }

        //가장자리는 어차피 꽃을 심을 수 없음
        //가장자리 제외하고 탐색
        for(int x=1;x<N-1;x++){
            for(int y=1;y<N-1;y++){
                //씨앗을 심을 수 있는 경우
                if(canPlant(x,y)){
                    //cost에 현재 탐색 위치의 땅값 저장
                    int cost=arr[x][y];

                    visit[x][y]=1;
                    for(int i=0;i<4;i++){
                        visit[x+dx[i]][y+dy[i]]=1; //방문처리!!!!
                        cost+=arr[x+dx[i]][y+dy[i]];
                    }
                    //다음 꽃을 심기
                    dfs(count+1,sum+cost);
                    //재귀 빠져나온 후, 심었던 꽃 위치들 초기화
                    remove(x,y);
                }
            }
        }

    }

    private static boolean canPlant(int x,int y){
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(visit[nx][ny]!=0){
                return false;
            }
        }

        return true;
    }

    private static void remove(int x,int y){
        visit[x][y]=0;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            visit[nx][ny]=0;
        }
    }
}
