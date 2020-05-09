package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16236_아기상어 {
    static class Fish {
        int row, col, size, swallow, moveCnt;

        public Fish(int row, int col) {
            this.row = row;
            this.col = col;
            this.size = 2;
            this.swallow = 0;
            this.moveCnt = 0;
        }

        public void updateSize() {
            if (this.size == this.swallow) {
                // 현재 아기상어의 크기와 먹은 물고기의 횟수가 같다면
                this.size++; // 현재 아기상어의 크기를 1 증가
                this.swallow = 0; // 먹은 회수 초기화
            }
        }
    }

    static class Node implements Comparable<Node> {
        int row, col, cnt;

        public Node(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if (this.row < node.row) { // 높이를 기준으로 위에 있는 물고기를 우선순위 옮김
                return -1;
            } else if (this.row == node.row) { // 높이가 같다면
                if (this.col < node.col) { // 왼쪽에 있는 물고기를 우선순위로 옮김
                    return -1;
                } else if (this.col == node.col) { // 같다면 그대로
                    return 0;
                }
                return 1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    static Fish fish;
    static PriorityQueue<Node> pq;
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 상 좌 우 하

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 9) {
                    fish = new Fish(i, j);
                    map[i][j] = 0;
                }
            }
        }
        pq = new PriorityQueue<>();

        solution();

        System.out.println(fish.moveCnt);
    }

    private static void solution() {
        while (true) {
            // 일단 Queue에 아기 상어를 집어넣고 판별
            Queue<Node> queue = new LinkedList<>();
            visit = new boolean[N][N];
            visit[fish.row][fish.col] = true;
            queue.offer(new Node(fish.row, fish.col, 0));
            int isSwallowCnt = 0;
            top:
            while (true) {
                int queueSize = queue.size();
                if(queueSize == 0)
                    return;
                while (queueSize-- > 0) {
                    Node curNode = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = curNode.row + dir[i][0];
                        int nc = curNode.col + dir[i][1];

                        // 범위 밖이며, 방문했으며, 아기상어의 크기보다 크다면
                        if (!isIn(nr, nc) || visit[nr][nc] || map[nr][nc] > fish.size)
                            continue;

                        if (map[nr][nc] == 0) {
                            // 다음 위치가 바다인 경우
                            queue.offer(new Node(nr, nc, curNode.cnt + 1));
                            visit[nr][nc] = true;
                        } else {
                            // 다음 위치가 바다가 아닌 경우
                            if (map[nr][nc] == fish.size) {
                                // 다음위치가 아기상어와 크기가 같다면
                                queue.offer(new Node(nr, nc, curNode.cnt + 1));
                                visit[nr][nc] = true;
                            } else if (map[nr][nc] < fish.size) {
                                // 다음위치가 아기상어의 크기보다 작다면
                                pq.offer(new Node(nr, nc, curNode.cnt + 1));
                                isSwallowCnt++;
                                visit[nr][nc] = true;
                            }
                        }
                    }
                }
                if (!pq.isEmpty()) {
                    // 4방향을 봤을때, 작은 물고기들이 1개이상 발견 되었다면
                    Node swallowNode = pq.poll();
                    fish.swallow++;
                    fish.updateSize();
                    fish.moveCnt += swallowNode.cnt;
                    fish.row = swallowNode.row;
                    fish.col = swallowNode.col;
                    map[swallowNode.row][swallowNode.col] = 0; // 먹어치운뒤 0
                    pq.clear();
                    break top;
                }
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }
}