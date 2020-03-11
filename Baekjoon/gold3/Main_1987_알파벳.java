package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
    static int row, col, result = Integer.MIN_VALUE;
    static char[][] map;
    static boolean[] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        visit = new boolean[26];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 처리
        dfs(0, 0, 1);

        // 출력
        System.out.println(result);
    }

    private static void dfs(int r, int c, int cnt) {
        visit[map[r][c] - 'A'] = true;
        result = Math.max(result, cnt);
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
                continue;
            }
            if (visit[map[nr][nc] - 'A']) {
                continue;
            }
            dfs(nr, nc, cnt + 1);
        }
        visit[map[r][c] - 'A'] = false;
    }
}
