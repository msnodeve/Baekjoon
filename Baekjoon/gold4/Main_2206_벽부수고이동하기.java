package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Wall {
    int row;
    int col;
    int chance;
    int cnt;

    public Wall(int row, int col, int chance, int cnt) {
        this.row = row;
        this.col = col;
        this.chance = chance;
        this.cnt = cnt;
    }
}

public class Main_2206_벽부수고이동하기 {
    static int rowN, colN;
    static int[][] visit; // 뚫고갔는지 안뚫고 갔는지 체크하는 배열
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        visit = new int[rowN][colN];
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                map[i][j] = br.read() - 48;
                visit[i][j] = Integer.MAX_VALUE;
            }
            br.readLine();
        }

        // 처리
        bfs(0, 0);

        // 출력
        System.out.println(result);
    }

    private static void bfs(int row, int col) {
        LinkedList<Wall> queue = new LinkedList<>();
        // (1, 1) 부터 시작, 뚫은 회수, 이동한 거리
        queue.offer(new Wall(row, col, 0, 1));
        visit[row][col] = 0; // 처음에는 아무것도 안 뚫고 시작

        while (!queue.isEmpty()) {
            Wall location = queue.poll();
            // 도착지점에 왔다면
            if (location.row == rowN - 1 && location.col == colN - 1) {
                // 이동한 거리, result
                result = location.cnt;
                return;
            }
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = location.row + dir[i][0];
                int nc = location.col + dir[i][1];

                // 내부로 들어왔을 경우
                if (nr > -1 && nc > -1 && nr < rowN && nc < colN) {
                    // 벽을 뚫은 회수보다 크다면 (방문하지 않았다면)
                    if (visit[nr][nc] > location.chance) {
                        // 벽이 아닐때
                        if (map[nr][nc] == 0) {
                            // 뚫은 회수를 그대로, 이동한 거리 1증가
                            queue.offer(new Wall(nr, nc, location.chance, location.cnt + 1));
                            visit[nr][nc] = location.chance;
                        }
                        // 벽일 때
                        else {
                            // 한번도 뚫은 적이 없다면
                            if (location.chance == 0) {
                                // 뚫은 회수 1증가, 이동한 거리 1증가
                                queue.offer(new Wall(nr, nc, location.chance + 1, location.cnt + 1));
                                visit[nr][nc] = location.chance + 1;
                            }
                        }
                    }
                }
            }
        }
        result = -1;
    }
}
