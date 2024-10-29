package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3085 {
    static char[][] arr;
    static int n;
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr=new char[n][n];

        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j]=s.charAt(j);
            }
        }

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char cur=arr[i][j];
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                    //교환
                    swap(i,j,nx,ny);
                    //최대 길이 탐색 체크
                    checkMax();
                    //다시 원래대로 돌려놓기
                    swap(i,j,nx,ny);
                }
            }
        }

        System.out.println(max);
    }

    private static void swap(int x1,int y1,int x2,int y2){
        char temp=arr[x1][y1];
        arr[x1][y1]=arr[x2][y2];
        arr[x2][y2]=temp;
    }

    private static void checkMax(){
        //row check
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=1;j<n;j++){
                if(arr[i][j]==arr[i][j-1]){
                    count++;
                }else{
                    count=1;
                }
                max=Math.max(max,count);
            }
        }

        //column check
        for(int j=0;j<n;j++){
            int count=1;
            for(int i=1;i<n;i++){
                if(arr[i][j]==arr[i-1][j]){
                    count++;
                }else{
                    count=1;
                }
                max=Math.max(max,count);
            }
        }
    }
}
