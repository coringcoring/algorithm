package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        char[][] map=new char[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=s.charAt(j);
            }
        }

        int count1=0;
        int count2=0;

        int x=0;
        int y=0;

        //가로 탐색
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]=='.'){
                    x++;
                    if(x==2) count1++;
                }else{
                    x=0;
                }
            }
            x=0;
        }

        //세로 탐색
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[j][i]=='.'){
                    y++;
                    if(y==2) count2++;
                }else{
                    y=0;
                }
            }
            y=0;
        }

        System.out.println(count1+" "+count2);
    }
}
