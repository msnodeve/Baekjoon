package silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {
    static int N;
    static int sum;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(br.readLine());

            if (inputNum == 0) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(inputNum);
            }
        }

        for (int num : stack) {
            sum += num;
        }

        System.out.println(sum);
    }
}
