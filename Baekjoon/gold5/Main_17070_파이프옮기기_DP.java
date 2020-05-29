package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기_DP {

    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N][3]; // 가로 대각선 세로로 온 경로 저장

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;
        System.out.println(dp());
    }

    private static int dp() {
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) { // 어차피 먼저 가로로 놔져있기 때문에 2부터 돌림
                if (map[i][j] == 1)
                    continue; // 놓을 위치가 벽이라면 다음

                // 가로로 먼저 놓기(j-1 번째)로 올수있는 방향은 가로, 대각선
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];

                if (i == 0)
                    continue; // i가 0일때는 그냥 버려도됨

                // 세로로 놓을 것(i-1 번째)로 올수있는 방향은 세로, 대각선
                dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
                    continue; // 대각선으로 놓으려하는데 양쪽의 벽이 1이라면 패스
                // 대각선으로 놓을 것(i-1 번째, j-1 번째)로 올수 있는 방향은 모든방향
                dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
            }
        }
        // 마지막 구해진 값을 리턴
        return dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
    }
}
