package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1941_소문난칠공주 {
    static char[][] map;
    static boolean[] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        map = new char[5][5];
        visit = new boolean[25];

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 맵 확인
        /*for (char[] row : map) {
            System.out.println(Arrays.toString(row));
        }*/

        // 모든 정점에서 주변으로 7공주를 만들수 있는지 검사 시작
        for (int i = 0; i < 25; i++) {
            combination(i, 1, 0);
        }

        System.out.println(result);
    }

    private static void combination(int num, int cnt, int sCnt) {
        // 그자리가 이다솜 파라면?
        if (map[num / 5][num % 5] == 'S')
            sCnt++;
        // 그렇지 않다면 그냥 sCnt를 가지고 계속 이동

        // 그 사람의 위치 true로 해주며
        visit[num] = true;

        // 7명이 선택되 었다면
        if (cnt == 7) {
            // 이다솜 파가 4명이상이라면
            if (sCnt >= 4) {
                // 그 위치에서 모든게 연결이 되어있는지 확인해본다.
                if (dfs(num / 5, num % 5)) {
                    result++;
                }
            }

            // 7명이 선택이 되었다면 이 콤비네이션은 끝내야함
            visit[num] = false;
            return;
        }
        // 그 위치 다음것을 또 탐색 시작해야함
        for (int i = num + 1; i < 25; i++) {
            if (!visit[i]) {
                // 다음 위치를 탐색
                combination(i, cnt + 1, sCnt);
            }
        }

        // 처리가 끝나면 false로 백트래킹
        visit[num] = false;
    }

    private static boolean dfs(int row, int col) {
        // 연결 되어있는지 확인해보자
        boolean[][] vst = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        vst[row][col] = true;
        queue.offer(new int[]{row, col});
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = loc[0] + dir[i][0];
                int nc = loc[1] + dir[i][1];

                // 범위 밖이라면
                // 이미 방문한 곳이라면
                // 선택된자가 아니라면 다음 탐색
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || vst[nr][nc] || !visit[nr * 5 + nc])
                    continue;

                vst[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
                cnt++;
            }
        }
        return cnt == 7;
    }
}