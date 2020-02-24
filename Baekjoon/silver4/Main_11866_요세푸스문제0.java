package silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main_11866_요세푸스문제0 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        // 처리 및 출력력
       StringBuilder result = new StringBuilder("<");
        String temp = "";
        while(!list.isEmpty()){
            for (int i = 0; i < K - 1; i++) {
                list.offer(list.poll());
            }
            temp += list.poll() + ", ";
        }
        result.append(temp.substring(0, temp.length()-2) + ">");
        System.out.println(result.toString());
    }
}
