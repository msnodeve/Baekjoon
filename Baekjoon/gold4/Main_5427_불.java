package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5427_불 {
    static class Node {
        int row, col, cnt;
        char kind;

        public Node(int row, int col, char kind, int cnt) {
            this.row = row;
            this.col = col;
            this.kind = kind;
            this.cnt = cnt;
        }
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static List<Node> fireList;
    static Node sangun;
    static Queue<Node> queue;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            fireList = new ArrayList<>();
            queue = new LinkedList<>();
            map = new char[R][C];
            visit = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '@')
                        sangun = new Node(i, j, '@', 0);
                    else if (map[i][j] == '*')
                        queue.offer(new Node(i, j, '*', 0));
                }
            }

            queue.offer(sangun);
            int result = solution();
            System.out.println(result != -1 ? result : "IMPOSSIBLE");
        }
    }

    private static int solution() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node curNode = queue.poll();
                visit[curNode.row][curNode.col] = true;
                switch (curNode.kind) {
                    case '@':
                        // 나가기 전에 도착함
                        if (curNode.row == 0 || curNode.row == R - 1 || curNode.col == 0 || curNode.col == C - 1)
                            return curNode.cnt + 1;

                        for (int i = 0; i < 4; i++) {
                            int nr = curNode.row + dir[i][0];
                            int nc = curNode.col + dir[i][1];

                            // 범위 밖으로 나갔거나 이미 방문했고, 다음 지점이 불이라면
                            if (isOut(nr, nc) || visit[nr][nc] || map[nr][nc] == '*' || map[nr][nc] == '#')
                                continue;

                            queue.offer(new Node(nr, nc, '@', curNode.cnt + 1));
                            map[nr][nc] = '@';
                            visit[nr][nc] = true;
                        }

                        break;
                    case '*':
                        for (int i = 0; i < 4; i++) {
                            int nr = curNode.row + dir[i][0];
                            int nc = curNode.col + dir[i][1];

                            // 범위 밖으로 나갔거나 이미 방문했다면
                            if (isOut(nr, nc) || visit[nr][nc] || map[nr][nc] == '#')
                                continue;

                            queue.offer(new Node(nr, nc, '*', curNode.cnt + 1));
                            map[nr][nc] = '*';
                            visit[nr][nc] = true;
                        }
                        break;
                }
            }
        }
        return -1;
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= R || nc >= C;
    }
}
