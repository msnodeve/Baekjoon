package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
    static int N;
    static int M;
    static int startNode;
    static int[][] map;
    static boolean visit[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        int node, nextNode;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            nextNode = Integer.parseInt(st.nextToken());
            map[node][nextNode] = 1;
            map[nextNode][node] = 1;
        }

        dfs(startNode);
        visit = new boolean[N + 1];
        System.out.println();
        bfs(startNode);
    }

    private static void dfs(int startNode) {
        System.out.print(startNode + " ");
        visit[startNode] = true;

        for (int i = 1; i < N + 1; i++) {
            if (map[startNode][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int startNode) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visit[startNode] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i = 1; i < N + 1; i++) {
                if (map[temp][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
