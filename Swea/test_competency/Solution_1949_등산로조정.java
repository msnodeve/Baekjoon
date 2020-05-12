package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1949_등산로조정 {
    static int N, K;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<int[]> maxHeight;
    static int height, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            height = 0;
            result = 1;
            maxHeight = new ArrayList<>();
            map = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    height = Math.max(height, map[i][j]);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == height)
                        maxHeight.add(new int[]{i, j});
                }
            }

            for (int[] sol : maxHeight) {
                dfs(sol[0], sol[1], false, height, 1);
            }

            System.out.println("#" + testcase + " " + result);
        }
    }

    private static void dfs(int row, int col, boolean flag, int currentHeight, int cnt) {
        visit[row][col] = true;
        int curHeight = currentHeight;
        result = Math.max(result, cnt);

        // 일단 4방향 탐색 시작
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            // 범위 밖으로 넘어갔으며, 다음 지점이 이미 방문했던 지점이라면 패스
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
                continue;

            // 다음 위치의 높이를 가져옴
            int height = map[nr][nc];

            // 범위 밖으로 넘어가지 않았으며, 다음 지점이 방문한 적이 없다면
            // 다음 위지의 높이가 지금 현재위치의 높이 보다 낮다면
            if (height < curHeight) {
                dfs(nr, nc, flag, height, cnt + 1);
            } else {
                // 지금 위치와 다음 높이의 위치가 같거나 크면
                // 공사 친적이있다면 패스
                if (flag)
                    continue;

                // 공사 친적이 없다면
                // 1부터 K까지 공사를 한번 쳐본다
                for (int j = 1; j <= K; j++) {
                    // 만약 공사친 곳이 낮아진다면
                    if (height - j < curHeight) {
                        dfs(nr, nc, true, height - j, cnt + 1);
                    }
                }
            }
        }
        visit[row][col] = false;
    }
}
