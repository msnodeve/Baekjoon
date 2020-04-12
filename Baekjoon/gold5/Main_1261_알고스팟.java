package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1261_알고스팟 {
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

    static int rowN, colN;
    static int result;
    static int[][] map;
    static int[][] D;

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        colN = Integer.parseInt(st.nextToken());
        rowN = Integer.parseInt(st.nextToken());
        map = new int[rowN + 1][colN + 1];
        D = new int[rowN + 1][colN + 1];
        for (int i = 0; i < rowN + 1; i++) {
            Arrays.fill(D[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= rowN; i++) {
            for (int j = 1; j <= colN; j++) {
                map[i][j] = br.read() - '0';
            }
            br.readLine();
        }
        pq = new PriorityQueue<>();
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        pq.add(new Node(1, 1, 0));
        D[1][1] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.row == rowN && node.col == colN) {
                result = node.value;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = node.row + dir[i][0];
                int nc = node.col + dir[i][1];

                if (nr < 1 || nc < 1 || nr > rowN || nc > colN)
                    continue;
                if (D[nr][nc] > D[node.row][node.col] + map[nr][nc]) {
                    D[nr][nc] = D[node.row][node.col] + map[nr][nc];
                    pq.add(new Node(nr, nc, D[nr][nc]));
                }
            }
        }
    }
}