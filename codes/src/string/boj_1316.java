package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int count=N;

        for(int i=0;i<N;i++){
            boolean[] chk=new boolean[26]; //방문한 알파벳인지 체크
            int prev=0;
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                int cur=s.charAt(j);
                if(prev!=cur){//앞의 글자와 현재 글자가 다를때
                    if(chk[cur-'a']==false){ //처음 등장한 알파벳이라면
                        chk[cur-'a']=true;
                        prev=cur;
                    }else{//이미 등장했던 알파벳이라면
                        count--;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
