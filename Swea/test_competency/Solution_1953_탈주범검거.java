package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class Solution_1953_탈주범검거 {

    static int rowN, colN, sRow, sCol, L, result;
    static HashMap<Integer, int[][]> hashMap;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rowN = Integer.parseInt(st.nextToken());
            colN = Integer.parseInt(st.nextToken());
            sRow = Integer.parseInt(st.nextToken());
            sCol = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[rowN][colN];
            visit = new boolean[rowN][colN];
            result = 1;
            for (int i = 0; i < rowN; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < colN; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 처리
            bfs(sRow, sCol);

            // 출력
            System.out.println("#" + testcase + " " + result);
        }
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        visit[row][col] = true;
        queue.offer(new int[]{row, col});

        for (int l = 1; l < L; l++) {
            int size = queue.size();
            while (size-- > 0) {
                int[] loc = queue.poll();
                row = loc[0];
                col = loc[1];

                int[][] dir = hashMap.get(map[row][col]);
                for (int i = 0; i < dir.length; i++) {
                    int nr = row + dir[i][0];
                    int nc = col + dir[i][1];

                    if (nr < 0 || nc < 0 || nr >= rowN || nc >= colN || visit[nr][nc])
                        continue;

                    if (check(map[row][col], map[nr][nc], i)) {
                        visit[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        result++;
                    }
                }
            }
        }
    }

    private static boolean check(int cur, int next, int dir) {
        switch (cur) {
            case 1:
                if (dir == 0) // 상쪽
                    return next == 1 || next == 2 || next == 5 || next == 6;
                else if (dir == 1) // 하쪽
                    return next == 1 || next == 2 || next == 4 || next == 7;
                else if (dir == 2) // 좌쪽
                    return next == 1 || next == 3 || next == 4 || next == 5;
                else if (dir == 3) // 우쪽
                    return next == 1 || next == 3 || next == 6 || next == 7;
                break;
            case 2:
                if (dir == 0) // 상쪽
                    return next == 1 || next == 2 || next == 5 || next == 6;
                else if (dir == 1) { // 하쪽
                    return next == 1 || next == 2 || next == 4 || next == 7;
                }
                break;
            case 3:
                if (dir == 0) // 좌쪽
                    return next == 1 || next == 3 || next == 4 || next == 5;
                else if (dir == 1) // 우쪽
                    return next == 1 || next == 3 || next == 6 || next == 7;
                break;
            case 4:
                if (dir == 0) // 상쪽
                    return next == 1 || next == 2 || next == 5 || next == 6;
                else if (dir == 1) // 우쪽
                    return next == 1 || next == 3 || next == 6 || next == 7;
                break;
            case 5:
                if (dir == 0) // 우쪽
                    return next == 1 || next == 3 || next == 6 || next == 7;
                else if (dir == 1) // 하쪽
                    return next == 1 || next == 2 || next == 4 || next == 7;
                break;
            case 6:
                if (dir == 0) // 하쪽
                    return next == 1 || next == 2 || next == 4 || next == 7;
                else if (dir == 1) //좌쪽
                    return next == 1 || next == 3 || next == 4 || next == 5;
                break;
            case 7:
                if (dir == 0) // 상쪽
                    return next == 1 || next == 2 || next == 5 || next == 6;
                else if (dir == 1) // 좌쪽
                    return next == 1 || next == 3 || next == 4 || next == 5;
                break;
        }
        return false;
    }

    static void init() {
        hashMap = new HashMap<>();
        hashMap.put(1, new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}); // 상 하 좌 우
        hashMap.put(2, new int[][]{{-1, 0}, {1, 0}}); // 상 하
        hashMap.put(3, new int[][]{{0, -1}, {0, 1}}); // 좌 우
        hashMap.put(4, new int[][]{{-1, 0}, {0, 1}}); // 상 우
        hashMap.put(5, new int[][]{{0, 1}, {1, 0}}); // 우 하
        hashMap.put(6, new int[][]{{1, 0}, {0, -1}}); // 하 좌
        hashMap.put(7, new int[][]{{-1, 0}, {0, -1}}); // 상 좌
    }
}
