package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1912_연속합 {
    static int n;
    static int[] list, dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());

        // 처리
        dp[0] = list[0];
        for (int i = 1; i < n; i++)
            dp[i] = Math.max(dp[i - 1] + list[i], list[i]);

        // 출력
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
