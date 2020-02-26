package silver5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_2748_피보나치수2 {

    static long a, b, c;
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 및 처리 및 출력
        a = 0;
        b = 1;
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
        } else {
            for (int i = 1; i < N; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println(c);
        }
    }
}
