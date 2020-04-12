package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {
    static class Node implements Comparable<Node> {
        int row, col, value;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.value, node.value);
        }
    }

    static int N;
    static int[][] map;
    static int[][] D;
    static int result;
    static PriorityQueue<Node> pq;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int testcase = 1;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            map = new int[N][N];
            D = new int[N][N];
            result = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    D[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();
            System.out.println("Problem " + testcase++ + ": " + result);
        }
    }

    private static void bfs() {
        pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        D[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.row == N - 1 && node.col == N - 1) {
                result = node.value;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.row + dir[i][0];
                int nc = node.col + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;

                if (D[nr][nc] > D[node.row][node.col] + map[nr][nc]) {
                    D[nr][nc] = D[node.row][node.col] + map[nr][nc];
                    pq.add(new Node(nr, nc, node.value + map[nr][nc]));
                }
            }
        }
    }
}