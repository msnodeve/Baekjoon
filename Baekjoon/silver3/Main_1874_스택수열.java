package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {
    static int N, max, cnt = 1;
    static int[] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(list[i], max);
        }

        // 처리
        for (int i = 0; i < N; i++) {
            int num = list[i];
            while (true) {
                if (cnt > max + 1) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
                if (!stack.isEmpty()) {
                    if (num == stack.peek()) {
                        stack.pop();
                        sb.append("-\n");
                        break;
                    } else {
                        stack.push(cnt++);
                        sb.append("+\n");
                    }
                } else {
                    stack.push(cnt++);
                    sb.append("+\n");
                }
            }
        }
        // 출력
        System.out.println(sb.toString());
    }
}