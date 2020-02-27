package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_10826_피보나치수4 {
    static int N;
    static BigInteger a, b, c;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        a = BigInteger.ZERO;
        b = BigInteger.ONE;
        if (N == 0) {
            System.out.println(0);
        } else if (N == 1) {
            System.out.println(1);
        } else {
            for (int i = 1; i < N; i++) {
                c = a.add(b);
                a = b;
                b = c;
            }
            System.out.println(c);
        }
    }
}
