package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_2193_이친수 {
    static long[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 및 처리
        int n = Integer.parseInt(br.readLine());
        dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n != 1) {
            for (int i = 3; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[n]);
    }
}
