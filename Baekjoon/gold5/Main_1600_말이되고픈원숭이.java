package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
    static int rowN, colN, K, result;
    static int[][] map;
    static boolean[][][] visit;
    static int[][] dir1 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dir2 = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        colN = Integer.parseInt(st.nextToken());
        rowN = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        visit = new boolean[rowN][colN][31];
        for (int i = 0; i < rowN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리
        result = bfs();

        // 출력
        System.out.println(result);
    }

    private static int bfs() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, K}); // 현재위치, cnt, K 번움직일 수 있는 회수
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int row = loc[0];
            int col = loc[1];
            int cnt = loc[2];
            int k = loc[3];
            if (row < 0 || col < 0 || row > rowN-1 || col > colN-1) {
                continue;
            }
            if (map[row][col] == 1) {
                continue;
            }
            if (row == rowN - 1 && col == colN - 1) {
                return cnt;
            }
            if (visit[row][col][k]) {
                continue;
            }
            visit[row][col][k] = true;
            // 인접한 곳 탐색
            for (int i = 0; i < 4; i++) {
                int nr = row + dir1[i][0];
                int nc = col + dir1[i][1];
                queue.offer(new int[]{nr, nc, cnt + 1, k});
            }
            if (k == 0) {
                continue;
            }
            // 말처럼 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int nr = row + dir2[i][0];
                int nc = col + dir2[i][1];
                queue.offer(new int[]{nr, nc, cnt + 1, k - 1});
            }
        }
        return -1;
    }
}
