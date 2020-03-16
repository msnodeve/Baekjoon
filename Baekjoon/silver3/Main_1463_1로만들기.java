package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.print(dp(N));
    }

    private static int dp(int n) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = dp(n - 1) + 1;
        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], dp(n / 2) + 1);
        }
        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], dp(n / 3) + 1);
        }
        return dp[n];
    }
}
