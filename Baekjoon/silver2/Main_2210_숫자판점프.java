package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프 {
    static int[][] map = new int[5][5];
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, map[i][j] + "", 1);
            }
        }

        System.out.println(hashSet.size());
    }

    private static void dfs(int row, int col, String path, int cnt) {
        // 6개를 선택했다면
        if (cnt == 6) {
            if (!hashSet.contains(path)) {
                hashSet.add(path);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
                continue;

            dfs(nr, nc, path + map[nr][nc], cnt + 1);
        }
    }
}
