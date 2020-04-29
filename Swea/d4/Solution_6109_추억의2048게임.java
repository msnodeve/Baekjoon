package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임 {
    static int N;
    static int[][] map, result;
    static boolean[][] visit;
    static String command;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            command = st.nextToken();
            map = new int[N][N];
            visit = new boolean[N][N];
            result = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (N == 1) {
                System.out.println("#" + testcase);
                System.out.println(map[0][0]);
            } else {
                solution(command);
                // 출력
                System.out.println("#" + testcase);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println();
                }
            }


        }
    }

    private static void solution(String command) {
        switch (command) {
            case "left":
                left();
                break;
            case "right":
                right();
                break;
            case "up":
                up();
                break;
            case "down":
                down();
                break;
        }
    }

    private static void down() {
        for (int i = 0; i < N; i++) { // 열 개수 만큼 돌기
            int des = N - 1;
            boolean flag = false;
            for (int j = N - 1; j > -1; j--) {
                int dep = j - 1;
                if (j == 0 && !visit[j][i]) {
                    result[des--][i] = map[j][i];
                }
                if (dep < 0) {
                    break;
                }
                if (map[j][i] == 0 || visit[j][i])
                    continue;
                visit[j][i] = true;
                while (map[dep][i] == 0) {
                    dep--;
                    if (dep < 0) {
                        result[des--][i] = map[j][i];
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                if (map[j][i] == map[dep][i]) {
                    result[des--][i] = map[j][i] << 1;
                    visit[dep][i] = true;
                } else {
                    result[des--][i] = map[j][i];
                }
            }
        }
    }

    private static void up() {
        for (int i = 0; i < N; i++) { // 열 개수 만큼 돌기
            int des = 0;
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                int dep = j + 1;
                if (j == N - 1 && !visit[j][i]) {
                    result[des++][i] = map[j][i];
                }
                if (dep >= N) {
                    break;
                }
                if (map[j][i] == 0 || visit[j][i])
                    continue;
                visit[j][i] = true;
                while (map[dep][i] == 0) {
                    dep++;
                    if (dep >= N) {
                        result[des++][i] = map[j][i];
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                if (map[j][i] == map[dep][i]) {
                    result[des++][i] = map[j][i] << 1;
                    visit[dep][i] = true;
                } else {
                    result[des++][i] = map[j][i];
                }
            }
        }
    }

    private static void right() {
        for (int i = 0; i < N; i++) { // 행 개수 만큼 돌기
            int des = N - 1;
            boolean flag = false;
            for (int j = N - 1; j > -1; j--) {
                int dep = j - 1;
                if (j == 0 && !visit[i][j]) {
                    result[i][des--] = map[i][j];
                }
                if (dep < 0) {
                    break;
                }
                if (map[i][j] == 0 || visit[i][j])
                    continue;
                visit[i][j] = true;
                while (map[i][dep] == 0) {
                    dep--;
                    if (dep < 0) {
                        result[i][des--] = map[i][j];
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                if (map[i][j] == map[i][dep]) {
                    result[i][des--] = map[i][j] << 1;
                    visit[i][dep] = true;
                } else {
                    result[i][des--] = map[i][j];
                }
            }
        }
    }

    private static void left() {
        for (int i = 0; i < N; i++) { // 행 개수 만큼 돌기
            int des = 0;
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                int dep = j + 1;
                if (j == N - 1 && !visit[i][j]) {
                    result[i][des++] = map[i][j];
                }
                if (dep >= N) {
                    break;
                }
                if (map[i][j] == 0 || visit[i][j])
                    continue;
                visit[i][j] = true;
                while (map[i][dep] == 0) {
                    dep++;
                    if (dep >= N) {
                        result[i][des++] = map[i][j];
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                if (map[i][j] == map[i][dep]) {
                    result[i][des++] = map[i][j] << 1;
                    visit[i][dep] = true;
                } else {
                    result[i][des++] = map[i][j];
                }
            }
        }
    }
}
