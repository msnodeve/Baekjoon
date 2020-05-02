package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17141_연구소2 {
    static int N, M, result = Integer.MAX_VALUE;
    static List<int[]> possibleVirusList, wallList;
    static int[] numbers;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        possibleVirusList = new ArrayList<>();
        wallList = new ArrayList<>();
        numbers = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                switch (value) {
                    case 1:
                        map[i][j] = value;
                        wallList.add(new int[]{i, j});
                        break;
                    case 2:
                        possibleVirusList.add(new int[]{i, j});
                        break;
                }
            }
        }

        combination(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void combination(int cnt, int cur) {
        if (cnt == M) {
            List<int[]> virusList = new ArrayList<>();
            for (int num : numbers) {
                int[] virus = possibleVirusList.get(num);
                virusList.add(virus);
                map[virus[0]][virus[1]] = 2;
            }

            bfs(virusList);

            map = new int[N][N];
            for (int[] wall : wallList) {
                map[wall[0]][wall[1]] = 1;
            }
            return;
        }

        for (int i = cur; i < possibleVirusList.size(); i++) {
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    private static void bfs(List<int[]> virusList) {
        Queue<int[]> queue = new LinkedList<>();
        visit = new boolean[N][N];
        for (int[] virus : virusList) {
            queue.offer(new int[]{virus[0], virus[1], 0});
            visit[virus[0]][virus[1]] = true;
        }
        int resultCnt = 0;
        while (!queue.isEmpty()) {
            int[] curLoc = queue.poll();
            int row = curLoc[0];
            int col = curLoc[1];
            int cnt = curLoc[2];
            resultCnt = Math.max(resultCnt, cnt);
            for (int i = 0; i < 4; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == 1)
                    continue;

                visit[nr][nc] = true;
                map[nr][nc] = 2;
                queue.offer(new int[]{nr, nc, cnt + 1});
            }
        }

        if(check()){ // 0이 없다는 것을 캐치
            result = Math.min(result, resultCnt);
        }
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}