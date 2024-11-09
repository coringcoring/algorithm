package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deq = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            String[] list=s.split(" ");
            String command = list[0];

            switch(command) {
                case "1" : {
                    deq.addFirst(Integer.parseInt(list[1]));
                    break;
                }
                case "2" : {
                    deq.add(Integer.parseInt(list[1]));
                    break;
                }
                case "3" : {
                    if(deq.isEmpty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(deq.removeFirst()).append("\n");
                    }
                    break;
                }

                case "4" : {
                    if(deq.isEmpty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(deq.removeLast()).append("\n");
                    }
                    break;
                }
                case "5" : {
                    sb.append(deq.size()).append("\n");
                    break;
                }
                case "6" : {
                    if(deq.isEmpty()) {
                        sb.append("1\n");
                    }else {
                        sb.append("0\n");
                    }
                    break;
                }
                case "7" : {
                    if(deq.isEmpty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(deq.getFirst()).append("\n");
                    }
                    break;
                }

                case "8" : {
                    if(deq.isEmpty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(deq.getLast()).append("\n");
                    }
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
