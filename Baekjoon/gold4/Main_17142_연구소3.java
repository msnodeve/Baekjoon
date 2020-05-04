package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17142_연구소3 {
    static int N, M, result, safeCnt;
    static int[][] map;
    static boolean[][] visit;
    static int[] number;
    static List<int[]> virusList;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        map = new int[N][N];
        number = new int[M];
        virusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2)
                    virusList.add(new int[]{i, j});
                else if (value == 0)
                    safeCnt++;
                map[i][j] = value;
            }
        }

        combination(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void combination(int cnt, int cur) {
        if (cnt == M) {
            bfs(number);
            return;
        }

        for (int i = cur; i < virusList.size(); i++) {
            number[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    private static void bfs(int[] number) {
        int scnt = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        visit = new boolean[N][N];
        for (int virusIdx : number) {
            int[] virus = virusList.get(virusIdx);
            map[virus[0]][virus[1]] = 2;
            queue.offer(new int[]{virus[0], virus[1], 0});
            visit[virus[0]][virus[1]] = true;
        }
        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curNode[0] + dir[i][0];
                int nc = curNode[1] + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == 1)
                    continue;

                if (map[nr][nc] == 0) {
                    scnt++;
                    time = curNode[2] + 1;
                }
                visit[nr][nc] = true;
                queue.offer(new int[]{nr, nc, curNode[2] + 1});
            }
        }
        if (scnt == safeCnt) {
            result = Math.min(result, time);
        }
    }
}