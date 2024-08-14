package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        char[] a=br.readLine().toCharArray();
        char[] b=br.readLine().toCharArray();

        for(int i=0;i<a.length;i++){//and 연산
            if(a[i]=='1' && b[i]=='1'){
                System.out.print(1);
            }else System.out.print(0);
        }
        System.out.println();

        for(int i=0;i<a.length;i++){//or 연산
            if(a[i]=='1' || b[i]=='1'){
                System.out.print(1);
            }else System.out.print(0);
        }
        System.out.println();


        for(int i=0;i<a.length;i++){//xor 연산
            if(a[i]!=b[i]){
                System.out.print(1);
            }else System.out.print(0);
        }
        System.out.println();

        for(int i=0;i<a.length;i++){//not a 연산
            if(a[i]=='0'){
                System.out.print(1);
            }else System.out.print(0);
        }
        System.out.println();

        for(int i=0;i<b.length;i++){//not b 연산
            if(b[i]=='0'){
                System.out.print(1);
            }else System.out.print(0);
        }
        System.out.println();

    }
}
