package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행 {
    static int R, C, result;
    static char[][] map;
    static boolean[] alpha;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            alpha = new boolean[26];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = (char) br.read();
                }
                br.readLine();
            }
            // 처리
            alpha[map[0][0] - 'A'] = true;
            dfs(0, 0, 1);

            // 출력
            System.out.println("#" + testcase + " " + result);
        }

    }

    private static void dfs(int r, int c, int cnt) {
        result = Math.max(result, cnt);
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr > -1 && nc > -1 && nr < R && nc < C) {
                int temp = map[nr][nc] - 'A';
                if (!alpha[temp]) {
                    alpha[temp] = true;
                    dfs(nr, nc, cnt + 1);
                    alpha[temp] = false;
                }
            }
        }
    }
}
