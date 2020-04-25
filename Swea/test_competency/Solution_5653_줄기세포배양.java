package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
    static class Node {
        int row, col, value, time, status;
        // status 0 활성화, 1 비활성화, 2 죽음

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.time = value;
            this.status = 1;
        }
    }

    static int rowN, colN, K;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Node> queue;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rowN = Integer.parseInt(st.nextToken());
            colN = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[rowN + K + 2][colN + K + 2];
            visit = new boolean[rowN + K + 2][colN + K + 2];
            queue = new LinkedList<>();

            int r = K / 2 + 1;
            int c = K / 2 + 1;

            for (int i = r; i < r + rowN; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = c; j < c + colN; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] != 0) {
                        queue.offer(new Node(i, j, map[i][j]));
                        visit[i][j] = true;
                    }
                }
            }

            // 처리
            solution();
            System.out.println("#" + testcase + " " + queue.size());
        }
    }

    private static void solution() {
        for (int k = 1; k <= K; k++) {
            int size = queue.size();
            // 일단 queue에 있는 세포들을 확인해봐야함
            for (Node c : queue) {
                if (c.status == 0) { // 지금 상태가 활성화 인경우
                    for (int i = 0; i < 4; i++) { // 4방향 탐색 하며 큰놈 처리
                        int nr = c.row + dir[i][0];
                        int nc = c.col + dir[i][1];

                        // 방문하지 않았다면
                        if (!visit[nr][nc]) {
                            // 그리고 그 자리가 이미 있는 자리랑 비교했을때 크다면 변경
                            if (map[nr][nc] < c.value)
                                map[nr][nc] = c.value;
                        }
                    }
                }
            }

            for (int s = 0; s < size; s++) {
                Node curNode = queue.poll();
                if (curNode.status == 0) { // 활성화 상태라면
                    // 일단 활성화 상태 이므로 전이 시작
                    for (int i = 0; i < 4; i++) { // 4 방향 전이
                        int nr = curNode.row + dir[i][0];
                        int nc = curNode.col + dir[i][1];

                        if (visit[nr][nc])
                            continue;

                        // 이미 위에서 큰놈들을 처리해줬기 때문에
                        visit[nr][nc] = true;
                        // queue 에 다음 세포번식을 위해 삽입
                        queue.offer(new Node(nr, nc, map[nr][nc]));
                    }
                }

                // 지금 비활성화 라면
                if (curNode.status == 1) {
                    // 잠재기간을 - 1 해주며 그것이 0이라면 다음번에 활성화 되어야함
                    if (--curNode.time == 0)
                        curNode.status = 0;
                    // 또 지금 활성화 이며
                } else if (curNode.status == 0) {
                    // 활성기간이 이미 입력된 세포크기라면
                    if (++curNode.time == curNode.value)
                        // 죽음 상태
                        curNode.status = 2;
                }

                // 이미 죽었으니 패스
                if (curNode.status == 2)
                    continue;

                // 안죽고 아직 살아있다면(활성, 비활성) 번식을 위해 다음 삽입
                queue.offer(curNode);
            }
        }
    }
}

