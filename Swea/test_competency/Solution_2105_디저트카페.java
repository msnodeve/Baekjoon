package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
    static int N, result;
    static boolean[][] visit;
    static int[][] map;
    static int[][] dir = {{1, 1}, {-1, 1}, {-1, -1},  {1, -1}};
    static boolean[] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine().trim());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine().trim());
            result = -1;
            map = new int[N][N];
            visit = new boolean[N][N];
            list = new boolean[101];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 처리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visit[i][j] = true;
                    list[map[i][j]] = true;
                    dfs(i, j, 1, 0, new int[]{i, j});
                    list[map[i][j]] = false;
                    visit[i][j] = false;
                }
            }

            // 출력
            System.out.println("#" +testcase + " " + result);
        }
    }

    private static void dfs(int row, int col, int cnt, int direction, int[] rememberLocation) {
        if (direction == 4) {
            return;
        }
        int nr = row + dir[direction][0];
        int nc = col + dir[direction][1];
        if (nr > -1 && nc > -1 && nr < N && nc < N) {
            if (visit[nr][nc] || list[map[nr][nc]]) {
                if (nr == rememberLocation[0] && nc == rememberLocation[1]) {
                    result = Math.max(result, cnt);
                }
                return;
            }
            visit[nr][nc] = true;
            list[map[nr][nc]] = true;
            dfs(nr, nc, cnt + 1, direction, rememberLocation);
            dfs(nr, nc, cnt + 1, direction + 1, rememberLocation);
            list[map[nr][nc]] = false;
            visit[nr][nc] = false;
        }
    }
}
