package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502_연구소 {
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    static int rowN, colN;
    static int[][] map;
    static boolean[][] visit;
    static List<Node> virusList, groundList, wallList;
    static int result;
    static int[] numbers;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        virusList = new ArrayList<>();
        groundList = new ArrayList<>();
        wallList = new ArrayList<>();
        numbers = new int[3];

        for (int i = 0; i < rowN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    groundList.add(new Node(i, j));
                else if (map[i][j] == 2)
                    virusList.add(new Node(i, j));
                else
                    wallList.add(new Node(i, j));
            }
        }

        // 처리
        combination(0, 0);

        // 출력
        System.out.println(result);
    }

    private static void combination(int cnt, int cur) {
        if (cnt == 3) {
            for (int v : numbers) {
                Node curNode = groundList.get(v);
                map[curNode.row][curNode.col] = 1;
            }

            bfs();
            result = Math.max(result, sum());

            init();
            return;
        }
        for (int i = cur; i < groundList.size(); i++) {
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    private static void init() {
        map = new int[rowN][colN];
        for (Node node : virusList) {
            map[node.row][node.col] = 2;
        }
        for (Node node : wallList) {
            map[node.row][node.col] = 1;
        }
    }

    private static int sum() {
        int sum = 0;
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (map[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void bfs() {
        visit = new boolean[rowN][colN];
        Queue<Node> queue = new LinkedList<>();
        for (Node virusNode : virusList) {
            queue.offer(virusNode);
            visit[virusNode.row][virusNode.col] = true;
        }

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curNode.row + dir[i][0];
                int nc = curNode.col + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= rowN || nc >= colN || visit[nr][nc] || map[nr][nc] == 1)
                    continue;

                visit[nr][nc] = true;
                map[nr][nc] = 2;
                queue.offer(new Node(nr, nc));
            }
        }
    }
}