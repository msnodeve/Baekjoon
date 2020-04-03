package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_1699_제곱수의합 {
    static int N;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            memo[i] = i;
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                memo[i] = Math.min(memo[i], memo[i - (int) Math.pow(j, 2)] + 1);
            }
        }

        System.out.println(memo[N]);
    }
}
