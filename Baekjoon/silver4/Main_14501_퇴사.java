package silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        T = new int[N + 6];
        P = new int[N + 6];
        dp = new int[N + 6];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[T[i] + i] = Math.max(dp[T[i] + i], P[i] + dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
