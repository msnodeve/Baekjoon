package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17069_파이프옮기기2 {

    static int N;
    static int[][] map;
    static long[][][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    private static long solution() {
        dp[0][1][0] = 1; // 제일 처음에 가로로 놓여있는 상황
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (map[i][j] == 1)
                    continue;
                // 가로 확인
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];

                if (i == 0)
                    continue;
                dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
                    continue;

                dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        return dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
    }
}
