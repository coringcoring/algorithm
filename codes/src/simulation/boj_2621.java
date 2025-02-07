package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//반례: https://www.acmicpc.net/board/view/64912 참고함
//7번째 반례에서 문제 발견
public class boj_2621 {
    static char[] color=new char[5];
    static int[] num=new int[5];

    //0: R, 1:B, 2:Y, 3:G
    static int[] countColor=new int[4];
    static int[] countNum=new int[10];

    //같은 숫자 여러개 있을때, 해당 숫자 저장 변수
    static int same=0;

    //같은 숫자 3개/2개 있을때, 해당 숫자들 저장 변수
    static int same3=0;
    static int same2=0;

    //같은 숫자 2개/2개 있을때, 해당 숫자들 저장 변수
    static int big2=0;
    static int small2=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<5;i++){
            st=new StringTokenizer(br.readLine());
            color[i]=st.nextToken().charAt(0);
            num[i]=Integer.parseInt(st.nextToken());

            countNum[num[i]]++;

            if(color[i]=='R') countColor[0]++;
            else if(color[i]=='B') countColor[1]++;
            else if(color[i]=='Y') countColor[2]++;
            else if(color[i]=='G') countColor[3]++;
        }

        int result=0;
        boolean flag=false;

        boolean sameColor=isSameColor();
        boolean SequentialNum=isSequentialNum();
        boolean SameNum32=isSameNum_32();
        boolean SameNum2=isSameNum2();

//        System.out.println(SequentialNum);

        //가장 높은 숫자 찾기
        int max=num[0];
        for(int i=9;i>=1;i--){
            if(countNum[i]>0){
                max=i;
                break;
            }
        }

        //조건 1 검사
        if(sameColor && SequentialNum){
            flag=true;
            result=Math.max(max+900,result);
        }

        //조건 2 검사
        else if(isSameNum(4)){
            flag=true;
            result=Math.max(same+800,result);
        }

        //조건 3 검사
        else if(SameNum32){
            flag=true;
            result=Math.max(same3*10+same2+700,result);
        }

        //조건 4 검사
        else if(sameColor){
            flag=true;
            result=Math.max(max+600,result);
        }

        //조건 5 검사
        else if(SequentialNum){
            flag=true;
            result=Math.max(max+500,result);
        }

        //조건 6 검사
        else if(isSameNum(3)){
            flag=true;
            result=Math.max(same+400,result);
        }

        //조건 7 검사
        else if(SameNum2){
            flag=true;
            result=Math.max(big2*10+small2+300,result);
        }

        //조건 8 검사
        else if(isSameNum(2)){
            flag=true;
            result=Math.max(same+200,result);
        }

        //어떤 조건에도 해당하지 않는 경우
        else{
            result=Math.max(max+100,result);
        }

        System.out.println(result);

    }

    //카드 5장이 모두 같은 색깔인지
    private static boolean isSameColor(){
        for(int i=0;i<4;i++){
            if(countColor[i]==5){
                return true;
            }
        }
        return false;
    }

    //카드 5장의 숫자가 연속적인지
    private static boolean isSequentialNum(){
        int min=0;
        for(int i=1;i<=9;i++){
            //num이 가장 먼저 나오는 위치를 min에 저장 -> 최소값
            if(countNum[i]>0) {
                min=i;
                break;
            }
        }

        for(int i=min;i<min+5;i++){
            if(i>9){
                return false;
            }
        }

        for(int i=min;i<min+5;i++){
            if(countNum[i]!=1){
                return false;
            }
        }
        return true;
    }

    //일부 같은 숫자가 있는지
    //2번규칙(4장의 숫자 같을때), 6번규칙(3장의 숫자 같을때), 8번규칙(2장의 숫자 같을때)
    private static boolean isSameNum(int cnt){
        for(int i=9;i>=1;i--){
            if(countNum[i]==cnt){
                same=i;
                return true;
            }
        }
        return false;
    }

    //3장, 2장 숫자 같은거
    private static boolean isSameNum_32(){
        boolean flag3=false;
        boolean flag2=false;
        for(int i=1;i<=9;i++){
            if(countNum[i]==3) {
                flag3=true;
                same3=i;
            }
            if(countNum[i]==2) {
                flag2=true;
                same2=i;
            }

            if(flag3&&flag2){
                return true;
            }
        }

        return false;
    }

    //2장 같고 또다른 2장 같은지
    private static boolean isSameNum2(){
        int count=0;

        for(int i=1;i<=9;i++){
            if(countNum[i]==2){
                count++;

                if(count==1){
                    small2=i;
                }

                if(count==2){
                    big2=i;
                    return true;
                }
            }
        }

        return false;
    }
}
