package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10844_쉬운계단수 {
    static final int MOD = 1000000000;
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        n = Integer.parseInt(br.readLine());
        dp = new long[101][10];

        // 처리
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
            dp[2][i] = 2;
        }
        dp[2][9] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 1)
                    dp[i][j] = (dp[i - 2][j] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
                else if (j == 9)
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                else
                    dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
            }
        }

        // 출력
        System.out.println(Arrays.stream(dp[n]).sum() % MOD);
    }
}
