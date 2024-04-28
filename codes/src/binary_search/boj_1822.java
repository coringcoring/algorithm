package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1822 {
    static int nA,nB;
    static int[] arrA;
    static int[] arrB;
    static ArrayList<Integer> res=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        nA=Integer.parseInt(st.nextToken());
        nB=Integer.parseInt(st.nextToken());
        StringTokenizer st2=new StringTokenizer(br.readLine());
        arrA=new int[nA];
        for(int i=0;i<nA;i++){
            arrA[i]=Integer.parseInt(st2.nextToken());
        }
        arrB=new int[nB];
        int result=0;
        StringTokenizer st3=new StringTokenizer(br.readLine());
        for(int i=0;i<nB;i++){
            arrB[i]=Integer.parseInt(st3.nextToken());
        }
        Arrays.sort(arrB);//이진탐색 위해서 정렬해야함

        for(int i=0;i<nA;i++){
            if(!binary(arrA[i])){
                result++;
                res.add(arrA[i]);
            }
        }

        if(res.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(result);
            Collections.sort(res);
            for(int a: res){
                System.out.print(a+" ");
            }
        }


    }

    public static boolean binary(int num){
        int left=0;
        int right=nB-1;
        while(left<=right){
            int midindex=(left+right)/2;
            int mid=arrB[midindex];
            if(num<mid) right=midindex-1;
            else if (num>mid) left=midindex+1;
            else return true;
        }
        return false;
    }
}
