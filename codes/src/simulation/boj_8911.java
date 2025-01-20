package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //북동남서
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};

        while(T-->0){
            char[] s=br.readLine().toCharArray();
            int maxX=0;
            int maxY=0;
            int minX=0;
            int minY=0;

            int x=0;
            int y=0;

            //방향
            //북쪽: 0 , 서쪽: 3, 남쪽: 2 , 동쪽: 1
            int di=0;

            for(int i=0;i<s.length;i++){
                if(s[i]=='F'){
                    x+=dx[di];
                    y+=dy[di];
                }
                else if(s[i]=='B'){
                    x-=dx[di];
                    y-=dy[di];
                }
                else if(s[i]=='L'){
                    if(di==0) di=3;
                    else di-=1;
                }else if(s[i]=='R'){
                    if(di==3) di=0;
                    else di+=1;
                }

                maxX=Math.max(maxX,x);
                maxY=Math.max(maxY,y);
                minX=Math.min(minX,x);
                minY=Math.min(minY,y);
            }

            sb.append(Math.abs(maxX-minX)*Math.abs(maxY-minY)).append("\n");
        }

        System.out.println(sb);
    }
}
