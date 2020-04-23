package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class Solution_5215_햄버거다이어트 {
    static int N, kal;
    static int[][] dp;
    static int[][] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            kal = Integer.parseInt(st.nextToken());
            dp = new int[N + 1][kal + 1];
            list = new int[N + 1][2];
            Arrays.fill(dp[0], 0);
            for (int i = 1; i < N + 1; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < N + 1; i++) {
                for (int w = 1; w < kal + 1; w++) {
                    if (list[i][1] > w)
                        dp[i][w] = dp[i - 1][w];
                    else
                        dp[i][w] = Math.max(dp[i - 1][w - list[i][1]] + list[i][0], dp[i - 1][w]);
                }
            }
            System.out.println("#" + testcase + " " + dp[N][kal]);
        }
    }
}
