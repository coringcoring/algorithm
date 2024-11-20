package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            char[] arr=br.readLine().toCharArray();
            int k=Integer.parseInt(br.readLine());

            if (k==1){
                sb.append("1 1").append("\n");
                continue;
            }

            int[] count=new int[26];
            for(int j=0;j<arr.length;j++){
                count[arr[j]-'a']++;
            }

            int min=Integer.MAX_VALUE;
            int max=-1;

            for(int j=0;j<arr.length;j++){
                //알파벳 개수가 k개 보다 작으면 탐색할 필요 x
                if(count[arr[j]-'a']<k){
                    continue;
                }
                int cnt=1;

                for(int m=j+1;m<arr.length;m++){
                    if(arr[j]==arr[m]) cnt++;

                    if(cnt==k){
                        min=Math.min(min,m-j+1);
                        max=Math.max(max,m-j+1);
                        break;
                    }
                }
            }

            if(min==Integer.MAX_VALUE || max==-1){
                sb.append("-1").append("\n");
            }else{
                sb.append(min+" "+max).append("\n");
            }
        }

        System.out.println(sb);
    }
}
