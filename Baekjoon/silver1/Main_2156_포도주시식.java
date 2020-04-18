package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[10001];
        long[] list = new long[10001];
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        if (n >= 1) {
            dp[1] = list[1];
        }
        if (n >= 2) {
            dp[2] = list[1] + list[2];
        }
        if (n >= 3) {
            long case1 = dp[2]; // oox
            long case2 = dp[1] + list[3]; // oxo
            long case3 = list[2] + list[3]; // xoo
            dp[3] = Math.max(case1, Math.max(case2, case3));
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + list[i], dp[i - 3] + list[i - 1] + list[i]));
        }
        System.out.println(dp[n]);
    }
}
