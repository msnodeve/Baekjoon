package gold3;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17472_다리만들기2 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static int[][] map, graph;
    static int islandIdx; // 섬의 번호
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맵 확인
        /*for(int[] r : map){
            System.out.println(Arrays.toString(r));
        }*/

        islandIdx = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) { // 땅을 발견하면 거기를 기점으로 BFS 탐색
                    bfs(i, j);
                    islandIdx++;
                }
            }
        }

        // 섬 확인
        /*for(int[] r : map){
            System.out.println(Arrays.toString(r));
        }*/

        // 각 섬의 최단 거리를 구해야함
        graph = new int[islandIdx][islandIdx];
        for (int i = 2; i < islandIdx; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 1) {
                    makeGraph(i, j);
                }
            }
        }

        // 그래프 확인
        /*for(int[] row : graph){
            System.out.println(Arrays.toString(row));
        }*/

        System.out.println(prim());
    }

    static int prim() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        Vertex[] vertexes = new Vertex[islandIdx];
        for (int i = 2; i < islandIdx; i++) {
            if (i == 2) {
                vertexes[i] = new Vertex(i, 0);
            } else {
                vertexes[i] = new Vertex(i, INF);
            }
            pq.offer(vertexes[i]);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Vertex front = pq.poll();

            if (front.cost == INF) {
                return -1;
            }

            sum += front.cost;

            for (int i = 2; i < islandIdx; i++) {
                Vertex child = vertexes[i];
                if (pq.contains(child)) {
                    if (child.cost > graph[front.idx][i]) {
                        child.cost = graph[front.idx][i];
                        pq.remove(child);
                        pq.offer(child);
                    }
                }
            }
        }

        return sum;
    }

    private static void makeGraph(int row, int col) {
        int base = map[row][col];
        for (int d = 0; d < 4; d++) {
            for (int l = 1; ; l++) {
                int nr = row + dir[d][0] * l;
                int nc = col + dir[d][1] * l;

                if (isIn(nr, nc)) {
                    if (map[nr][nc] == 0) {
                        continue;
                    } else if (map[nr][nc] == base) {
                        break;
                    } else {
                        if (l > 2) {
                            graph[base][map[nr][nc]] = graph[map[nr][nc]][base] = Math.min(graph[base][map[nr][nc]], l - 1);
                        }
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    private static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col));
        map[row][col] = islandIdx;
        while (!queue.isEmpty()) {
            Point front = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = front.row + dir[d][0];
                int nc = front.col + dir[d][1];

                if (isIn(nr, nc) && map[nr][nc] == 1) {
                    map[nr][nc] = islandIdx;
                    queue.offer(new Point(nr, nc));
                }
            }
        }
    }

    static boolean isIn(int row, int col) {
        return 0 <= row && row < R && 0 <= col && col < C;
    }

    static class Vertex implements Comparable<Vertex> {
        int idx, cost;

        public Vertex(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex vertex) {
            return Integer.compare(this.cost, vertex.cost);
        }
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
