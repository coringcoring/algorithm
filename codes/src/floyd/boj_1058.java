package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        char[][] arr=new char[N][N];
        boolean[][] isFriend=new boolean[N][N];

        for(int i=0;i<N;i++){
            String line=br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j]=line.charAt(j);
            }
        }
        int max=Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            int two=0;
            for(int j=0;j<N;j++){
                if(arr[i][j]=='Y'){
                    isFriend[i][j]=true;
                    for(int k=0;k<N;k++){
                        if(arr[j][k]=='Y') isFriend[i][k]=true;
                    }
                }
            }

            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(isFriend[i][j]) two++;
            }

            max=Math.max(max,two);
        }
        System.out.println(max);
    }
}
