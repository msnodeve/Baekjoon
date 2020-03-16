package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_1868_파핑파핑지뢰찾기 {
    static int N, result;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                map[i] = line.toCharArray();
            }

            // 처리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 1. 만약 사방향중에 지뢰가 없는지 체크
                    // 2. 그 자리를 방문하지 않았다면
                    // 3. 그 자리가 . 이라면
                    if (check(i, j) && !visit[i][j] && map[i][j] == '.') {
                        // bfs를 돌면서 8방향 탐색 시작
                        bfs(i, j);
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 1. 방문하지 않았으며
                    // 2. 그 자리가 . 이며
                    // 3. 8방향 주변에 0이 아니라면
                    // => 이 결과 클릭만 해야하는 경우가 됨
                    if(!visit[i][j] && map[i][j] == '.' && checkCnt(i,j)){
                        result++;
                    }
                }
            }
            System.out.println("#" + testcase + " " + result);
        }
    }
    private static void bfs(int row, int col) {
        // 0 인 위치를 1개 +
        result++;
        // 그자리를 0으로 만듬
        map[row][col] = '0';
        // 8방향을 탐색하기 위한 Queue
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visit[row][col] = true;
        // 8방향에 지뢰가 있을때까지 넣은 뒤, Queue에서 다 뺄때까지 돌림
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            row = loc[0];
            col = loc[1];
            // 8방향에 지뢰가 없는 것을 확인했다면
            if (check(row, col)) {
                for (int i = 0; i < 8; i++) {
                    int nr = row + dir[i][0];
                    int nc = col + dir[i][1];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) {
                        continue;
                    }
                    // 그자리들을 다 넣음
                    queue.offer(new int[]{nr, nc});
                    visit[nr][nc] = true;
                }
            }
            // 8방향 주변에 지뢰가 하나라도 있다면
            else {
                // 지뢰를 탐색해서 카운트
                int cnt = 0;
                for (int i = 0; i < 8; i++) {
                    int nr = row + dir[i][0];
                    int nc = col + dir[i][1];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                        continue;
                    if (map[nr][nc] == '*')
                        cnt++;
                }
                // 그 자리를 카운트한 개수로 변경
                map[row][col] = (char) (cnt + '0');
            }
        }
    }

    private static boolean checkCnt(int row, int col){
        for (int k = 0; k < 8; k++) {
            int nr = row + dir[k][0];
            int nc = col + dir[k][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if(map[nr][nc] == '0')
                return false;
        }
        return true;
    }

    private static boolean check(int row, int col) {
        for (int i = 0; i < 8; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if (map[nr][nc] == '*') {
                return false;
            }
        }
        return true;
    }
}
