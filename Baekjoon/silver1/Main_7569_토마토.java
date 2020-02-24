package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
    static int rowN, colN, higN;
    static boolean[][][] visit;
    static int[][][] map;
    static int result = 1;
    static LinkedList<int[]> queue = new LinkedList<>();
    static int[][][] dir = new int[][][]{{{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}}, // 현재층에서의 동서남북 탐색 dir
            {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}},   // 윗층 탐색
            {{-1, 0, 0}, {-1, 0, 0}, {-1, 0, 0}, {-1, 0, 0}}}; // 아랫층 탐색

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        colN = Integer.parseInt(st.nextToken());
        rowN = Integer.parseInt(st.nextToken());
        higN = Integer.parseInt(st.nextToken());
        map = new int[higN][rowN][colN];
        visit = new boolean[higN][rowN][colN];
        for (int i = 0; i < higN; i++) {
            for (int j = 0; j < rowN; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < colN; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }


        // 처리
        for (int i = 0; i < higN; i++) {
            for (int j = 0; j < rowN; j++) {
                for (int k = 0; k < colN; k++) {
                    if (!visit[i][j][k] && map[i][j][k] == 1) { // 방문하지 않은 곳, 익은 토마토 인 경우 탐색
                        queue.offer(new int[]{i, j, k, 1});
                        visit[i][j][k] = true;
                    }
                }
            }
        }
        bfs();

        // 출력
        if (check()) {
            System.out.println(-1);
        } else {
            System.out.println(result-1);
        }
    }

    private static boolean check() {
        for (int i = 0; i < higN; i++) {
            for (int j = 0; j < rowN; j++) {
                for (int k = 0; k < colN; k++) {
                    int temp = map[i][j][k];
                    if (temp == 0) {
                        return true;
                    } else {
                        result = Math.max(result, temp);
                    }
                }
            }
        }
        return false;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int hig = location[0];
            int row = location[1];
            int col = location[2];
            int cnt = location[3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    int nh = hig + dir[i][j][0];
                    int nr = row + dir[i][j][1];
                    int nc = col + dir[i][j][2];

                    if (nh > -1 && nh < higN && nr > -1 && nr < rowN && nc > -1 && nc < colN  // 범위 밖으로 벗어났을 경우
                            && map[nh][nr][nc] == 0 // 다음 토마토(0)가 익지 않은 경우
                            && !visit[nh][nr][nc]   // 방문하지 않은 경우
                    ) {
                        map[nh][nr][nc] = cnt + 1;
                        queue.offer(new int[]{nh, nr, nc, cnt + 1});
                        visit[nh][nr][nc] = true; // 방문 표시
                    }
                }
            }
        }
    }
}
