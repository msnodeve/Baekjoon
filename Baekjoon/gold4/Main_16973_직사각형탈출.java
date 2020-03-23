package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {
    static int rowN, colN, H, W, sR, sC, fR, fC, result;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        visit = new boolean[rowN][colN];
        for (int i = 0; i < rowN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sR = Integer.parseInt(st.nextToken()) - 1;
        sC = Integer.parseInt(st.nextToken()) - 1;
        fR = Integer.parseInt(st.nextToken()) - 1;
        fC = Integer.parseInt(st.nextToken()) - 1;

        bfs(sR, sC);
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col, 0});
        visit[row][col] = true;
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            row = loc[0];
            col = loc[1];
            int cnt = loc[2];
            if (row == fR && col == fC) {
                result = Math.min(result, cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                // 하, 상, 우, 좌 순서
                if (check(i, row, col)) {
                    int nr = row + dir[i][0];
                    int nc = col + dir[i][1];
                    if(visit[nr][nc])
                        continue;
                    queue.offer(new int[]{nr, nc, cnt+1});
                    visit[nr][nc] = true;
                }
            }
        }
    }

    private static boolean check(int dir, int row, int col) {
        if (dir == 0) { // 하단 검사
            for (int i = col; i < col + W; i++) { // 가로 길이 만큼
                // 범위 밖이라면
                if (row + H >= rowN || i >= colN) {
                    return false;
                }
                // 벽이 있다면
                if (map[row + H][i] == 1) {
                    return false;
                }
            }
        }
        else if(dir == 1){// 상단 검사
            for (int i = col; i < col + W; i++) { // 가로 길이 만큼
                // 범위 밖이라면
                if (row - 1 < 0 || i < 0 || i >= colN) {
                    return false;
                }
                // 벽이 있다면
                if (map[row - 1][i] == 1) {
                    return false;
                }
            }
        }
        else if(dir == 2){// 우측 검사
            for (int i = row; i < row + H; i++) { // 세로 길이 만큼
                // 범위 밖이라면
                if(col + W >= colN || i >= rowN){
                    return false;
                }
                // 벽이 있다면
                if (map[i][col + W] == 1) {
                    return false;
                }
            }
        }
        else if(dir == 3){// 좌측 검사
            for (int i = row; i < row + H; i++) { // 세로 길이 만큼
                // 범위 밖이라면
                if(col - 1 < 0 || i < 0 || i >= rowN){
                    return false;
                }
                // 벽이 있다면
                if (map[i][col - 1] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
