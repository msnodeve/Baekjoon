package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님 {
    static int rowN, colN, result;
    static LinkedList<int[]> queue = new LinkedList<>();
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rowN = Integer.parseInt(st.nextToken());
            colN = Integer.parseInt(st.nextToken());
            result = -1;
            map = new char[rowN][colN];
            visit = new boolean[rowN][colN];
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    char index = (char) br.read();
                    map[i][j] = index;
                    switch (index) {
                        case '*':
                            queue.offer(new int[]{i, j, 0});
                            visit[i][j] = true;
                            break;
                        case 'S':
                            queue.offerFirst(new int[]{i, j, 0});
                            visit[i][j] = true;
                            break;
                    }
                }
                br.readLine();
            }

            // 처리
            bfs();

            // 출력
            if (result == -1) {
                System.out.println("#" + testcase + " GAME OVER");
            } else {
                System.out.println("#" + testcase + " " + result);
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int curR = loc[0];
            int curC = loc[1];
            for (int i = 0; i < 4; i++) {
                int nr = curR + dir[i][0];
                int nc = curC + dir[i][1];
                if (nr > -1 && nc > -1 && nr < rowN && nc < colN) {
                    // 현재 위치가 지은이라면
                    if (map[curR][curC] == 'S') {
                        // 현재 지은인데, 다음지역이 여신이라면 도착
                        if (map[nr][nc] == 'D') {
                            result = loc[2] + 1;
                            return;
                        }
                        // 다음 지역을 방문하지 않았으며, 비어있는 공간이라면
                        if (!visit[nr][nc] && map[nr][nc] == '.') {
                            queue.offer(new int[]{nr, nc, loc[2] + 1});
                            map[nr][nc] = 'S';
                            visit[nr][nc] = true;
                        }
                    }
                    // 현재 위치가 악마라면
                    else if (map[curR][curC] == '*') {
                        // 위치가 지은이라면
                        if (map[nr][nc] == 'S') {
                            queue.offer(new int[]{nr, nc, 0});
                            map[nr][nc] = '*';
                            visit[nr][nc] = true;
                        }
                        // 다음 지역을 방문하지 않았으며, 돌이 아니라면
                        if (!visit[nr][nc] && map[nr][nc] != 'X' && map[nr][nc] != 'D') {
                            queue.offer(new int[]{nr, nc, 0});
                            map[nr][nc] = '*';
                            visit[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
}
