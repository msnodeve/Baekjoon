package gold5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main_15683_감시 {
    static class Camera {
        int row, col, kind;

        public Camera(int row, int col, int kind) {
            this.row = row;
            this.col = col;
            this.kind = kind;
        }
    }

    static int N, M;
    static int[][] map;
    static List<Camera> list;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    list.add(new Camera(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);

        System.out.println(result);
    }

    private static void dfs(int idx, int[][] prev) {
        if (idx == list.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (prev[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            result = Math.min(result, cnt);
            return;
        }

        int[][] v = new int[N][M];
        Camera camera = list.get(idx);
        int row = camera.row;
        int col = camera.col;
        switch (camera.kind) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < N; j++) {
                        v[j] = Arrays.copyOf(prev[j], M);
                    }
                    detect(v, row, col, i);
                    dfs(idx + 1, v);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < N; j++) {
                        v[j] = Arrays.copyOf(prev[j], M);
                    }
                    detect(v, row, col, i);
                    detect(v, row, col, i + 2);
                    dfs(idx + 1, v);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < N; j++) {
                        v[j] = Arrays.copyOf(prev[j], M);
                    }
                    detect(v, row, col, i);
                    detect(v, row, col, (i + 1) % 4);
                    dfs(idx + 1, v);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < N; j++) {
                        v[j] = Arrays.copyOf(prev[j], M);
                    }
                    detect(v, row, col, i);
                    detect(v, row, col, (i + 1) % 4);
                    detect(v, row, col, (i + 2) % 4);
                    dfs(idx + 1, v);
                }
                break;
            case 5:
                for (int j = 0; j < N; j++) {
                    v[j] = Arrays.copyOf(prev[j], M);
                }
                for (int i = 0; i < 4; i++) {
                    detect(v, row, col, i);
                }
                dfs(idx+1, v);
                break;
        }
    }

    private static void detect(int[][] v, int row, int col, int dir) {
        switch (dir) {
            case 0: // 좌
                for (int i = col; i > -1; i--) {
                    if (v[row][i] == 6)
                        break;
                    v[row][i] = 9;
                }
                break;
            case 1: // 상
                for (int i = row; i > -1; i--) {
                    if (v[i][col] == 6)
                        break;
                    v[i][col] = 9;
                }
                break;
            case 2: // 우
                for (int i = col; i < M; i++) {
                    if (v[row][i] == 6)
                        break;
                    v[row][i] = 9;
                }
                break;
            case 3: // 하
                for (int i = row; i < N; i++) {
                    if (v[i][col] == 6)
                        break;
                    v[i][col] = 9;
                }
                break;
        }
    }
}