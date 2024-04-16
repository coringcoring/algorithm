package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2529 {
    static int n;
    static char[] arr;
    static boolean[] visit=new boolean[10]; //0~9 방문 여부
    static List<String> result=new ArrayList<>();
    static String minNum="9999999999";
    static String maxNum="0";
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new char[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=st.nextToken().charAt(0);
        }
        for(int i=0;i<10;i++){
            visit[i]=false;
        }
        dfs(0,"");

        System.out.println(maxNum);
        System.out.println(minNum);
    }
    public static void dfs(int level,String num){
        if (level==n+1){
            if(Long.parseLong(num)>Long.parseLong(maxNum)){
                maxNum=num;
            }
            if(Long.parseLong(num)<Long.parseLong(minNum)){
                minNum=num;
            }
            return;
        }
        for(int i=0;i<10;i++){
            if(!visit[i]){
                if(level==0 || possible(num.charAt(level-1)-'0',i,arr[level-1])){
                    visit[i]=true;
                    dfs(level+1,num+i);
                    visit[i]=false;
                }
            }
        }
    }

    public static boolean possible(int a, int b, char operator) {
        if(operator=='<'){
            return a<b;
        }
        else{ //< 일 경우
            return a>b;
        }
    }
}
