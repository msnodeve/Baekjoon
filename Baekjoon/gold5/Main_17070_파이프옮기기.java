package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17070_파이프옮기기 {

    static int N, result;
    static int[][] map;
    static int[][] dir = {{}, {0, 1}, {1, 1}, {1, 0}}; // 1: 가로, 2: 대각선, 3: 세로

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1, 1, 2);
        System.out.println(result);
    }

    private static void solution(int kind, int row, int col) {
        int nr, nc;
        switch (kind) {
            case 1: // 현재 가로로 놓아져 있을때,
                for (int i = 1; i <= 2; i++) {
                    nr = row + dir[i][0];
                    nc = col + dir[i][1];
                    if (isOut(nr, nc) || map[nr][nc] == 1 || i == 2 && checkWall(nr, nc))
                        continue; // 범위 밖이라면, 다음 지점이 벽이라면, 대각선일 때 나머지 2방향 벽이아닌지 체크
                    if (nr == N && nc == N) { // 도착지점이라면
                        result++;
                        return;
                    }
                    solution(i, nr, nc);
                }
                break;
            case 2: // 현재 대각선으로 놓아져 있을때,
                for (int i = 1; i <= 3; i++) {
                    nr = row + dir[i][0];
                    nc = col + dir[i][1];
                    if (isOut(nr, nc) || map[nr][nc] == 1 || i == 2 && checkWall(nr, nc))
                        continue; // 범위 밖이라면, 다음 지점이 벽이라면, 대각선일 때 나머지 2방향 벽이아닌지 체크
                    if (nr == N && nc == N) { // 도착지점이라면
                        result++;
                        return;
                    }
                    solution(i, nr, nc);
                }
                break;
            case 3: // 현재 세로로 놓아져 있을때,
                for (int i = 2; i <= 3; i++) {
                    nr = row + dir[i][0];
                    nc = col + dir[i][1];
                    if (isOut(nr, nc) || map[nr][nc] == 1 || i == 2 && checkWall(nr, nc))
                        continue; // 범위 밖이라면, 다음 지점이 벽이라면, 대각선일 때 나머지 2방향 벽이아닌지 체크
                    if (nr == N && nc == N) { // 도착지점이라면
                        result++;
                        return;
                    }
                    solution(i, nr, nc);
                }
                break;
        }
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 1 || nc < 1 || nr > N || nc > N;
    }

    private static boolean checkWall(int nr, int nc) {
        return map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1; // 나머지 2방향이 벽이라면 트루
    }
}
