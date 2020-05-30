package silver5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
    static BigInteger[] factorial;
    static int N, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전처리
        factorial = new BigInteger[30];
        factorial[0] = new BigInteger("1");
        for (int i = 1; i < 30; i++)
            factorial[i] = factorial[i-1].multiply(new BigInteger(String.valueOf(i)));

        // 확인
        // System.out.println(Arrays.toString(factorial));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 처리
            BigInteger n = factorial[M];
            BigInteger r = factorial[M-N].multiply(factorial[N]);

            // 출력
            System.out.println(n.divide(r));
        }
    }
}
