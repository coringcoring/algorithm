package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_3190 {
    static int n,k,l;
    static int[][] arr;
    //동 남 서 북
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};

    static List<int[]> snake=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());

        arr=new int[n][n];

        StringTokenizer st;
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            arr[a][b]=1;
        }

        l=Integer.parseInt(br.readLine());
        int[] second=new int[l];
        int[] direct=new int[l];

        for(int i=0;i<l;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            char b=st.nextToken().charAt(0);
            second[i]=a;
            if(b=='D'){//오른쪽
                direct[i]=1;
            }else{//왼쪽
                direct[i]=0;
            }
        }


        int time=0;
        //시작 좌표
        int x=0;
        int y=0;
        int d=0; //시작 방향- 동쪽
        snake.add(new int[]{x,y});

        while(true){
            time++;

            int nx=x+dx[d];
            int ny=y+dy[d];

            if(isFinish(nx,ny)){
                break;
            }

            if(arr[nx][ny]==1){
                arr[nx][ny]=0;
                snake.add(new int[]{nx,ny});
            }else{
                snake.add(new int[]{nx,ny});
                snake.remove(0);
            }

            for(int i=0;i<second.length;i++){
                if(time==second[i]){
                    if(direct[i]==1){//오른쪽
                        d+=1;
                        if(d==4) d=0;
                    }else{//왼쪽
                        d-=1;
                        if(d==-1) d=3;
                    }
                }
            }

            x=nx;
            y=ny;
        }

        System.out.println(time);
    }

    private static boolean isFinish(int nx,int ny){
        //범위를 벗어갈 때
        if(nx<0 || ny<0 || nx>=n || ny>=n){
            return true;
        }

        //뱀의 몸통을 만날때
        for(int i=0;i<snake.size();i++){
            int x=snake.get(i)[0];
            int y=snake.get(i)[1];
            if(nx==x && ny==y){
                return true;
            }
        }
        return false;
    }

}
