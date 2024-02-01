package sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class boj_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());//배열 크기 입력받음
        ArrayList<Integer> arr=new ArrayList(); //배열 생성 (Collections.sort() 사용 위해 ArrayList)

        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        //큰 데이터셋의 경우: 선택정렬과 달리 퀵,병합 등의 정렬 알고리즘 사용 필요
        //퀵 정렬 사용 -> 시간 초과 발생
        //구글링 결과: Tim 정렬인 Collections.sort() 사용이 불가피
        //Tim 정렬 공부 필요..
        // Tim 정렬 시간복잡도: O(n)~ O(nlogn)

        Collections.sort(arr);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr.get(i)+"\n");
        }

        bw.write(sb.toString());
        bw.flush(); //버퍼에 저장된 내용을 클라이언트에 전송하고 버퍼 비움
        bw.close();
        br.close();
    }
}
