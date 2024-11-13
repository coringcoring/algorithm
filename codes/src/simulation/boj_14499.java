package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14499 {
    static int N,M,x,y;
    static int[][] map;
    static StringBuilder sb=new StringBuilder();

    private static class Dice{
        int top;
        int bottom;
        int left;
        int right;
        int front;
        int back;

        private Dice(){
            this.top=0;
            this.bottom=0;
            this.left=0;
            this.right=0;
            this.front=0;
            this.back=0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        //y x를 반대로 준다..
        y=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());

        int K=Integer.parseInt(st.nextToken());

        map=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        Dice dice=new Dice();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int num=Integer.parseInt(st.nextToken());
            if(num==1){//동쪽
                int nx=x+1;
                int ny=y;
                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    int temp=dice.left;
                    dice.left=dice.bottom;
                    dice.bottom=dice.right;
                    dice.right=dice.top;
                    dice.top=temp;
                    change(dice,nx,ny);
                }
            }else if(num==2){//서쪽
                int nx=x-1;
                int ny=y;
                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    int temp=dice.bottom;
                    dice.bottom=dice.left;
                    dice.left=dice.top;
                    dice.top=dice.right;
                    dice.right=temp;
                    change(dice,nx,ny);
                }
            }else if(num==3){//북쪽
                int nx=x;
                int ny=y-1;
                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    int temp=dice.front;
                    dice.front=dice.bottom;
                    dice.bottom=dice.back;
                    dice.back=dice.top;
                    dice.top=temp;
                    change(dice,nx,ny);
                }
            }else if(num==4){//남쪽
                int nx=x;
                int ny=y+1;
                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    int temp=dice.bottom;
                    dice.bottom=dice.front;
                    dice.front=dice.top;
                    dice.top=dice.back;
                    dice.back=temp;
                    change(dice,nx,ny);
                }
            }
        }
        System.out.println(sb);

    }

    private static void change(Dice dice,int nx,int ny){
        if(map[ny][nx]==0){
            map[ny][nx]=dice.bottom;
        }else{
            dice.bottom=map[ny][nx];
            map[ny][nx]=0;
        }
        x=nx;
        y=ny;
        sb.append(dice.top).append("\n");
    }
}
