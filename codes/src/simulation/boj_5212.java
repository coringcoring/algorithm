package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5212 {
    static int R,C;
    static char[][] map;
    //업데이트 갱신할 맵 (=업데이트 과정 중에 다른 변경된 사항이 바다가 될지를 결정하는 판단에 영향을 주면 안되므로)
    //ex. 옆에 육지가 바다로 변한 후, 다음 좌표에서 판단 시 바다로 변한 결과가 영향을 주면 안됨(=카운트 되면 안됨)
    static char[][] newMap;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new char[R][C];
        newMap=new char[R][C];

        for(int i=0;i<R;i++){
            String line=br.readLine();
            for(int j=0;j<C;j++){
                char ch=line.charAt(j);
                map[i][j]=ch;
                newMap[i][j]=ch;
            }
        }

        // 50년 후 지도 갱신
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]=='X'){
                    int cnt=0;
                    for(int k=0;k<4;k++){
                        int nx=i+dx[k];
                        int ny=j+dy[k];

                        if(nx<0 || ny<0 || nx>=R || ny>=C || map[nx][ny]=='.'){
                            cnt++;
                        }
                    }

                    if(cnt>=3){
                        newMap[i][j]='.';
                    }
                }
            }
        }

        //지도의 경계 찾기
        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(newMap[i][j]=='X'){
                    minX=Math.min(minX,i);
                    maxX=Math.max(maxX,i);
                    minY=Math.min(minY,j);
                    maxY=Math.max(maxY,j);
                }
            }
        }

//        System.out.println(minX);
//        System.out.println(minY);
//        System.out.println(maxX);
//        System.out.println(maxY);

        for(int i=minX;i<=maxX;i++){
            for(int j=minY;j<=maxY;j++){
                System.out.print(newMap[i][j]);
            }
            System.out.println();
        }

    }
}
