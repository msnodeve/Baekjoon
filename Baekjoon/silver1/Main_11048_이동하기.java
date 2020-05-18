package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_11048_이동하기 {
    static int N, M;
    static int[][] map;
    static int[] list;
    static int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}}; // 좌, 좌상, 상

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                list = new int[3];
                // 3방 탐색
                for (int k = 0; k < 3; k++) {
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];

                    if (isOut(nr, nc)) {
                        list[k] = map[i][j];
                        continue;
                    }
                    list[k] = map[i][j] + map[nr][nc]; // 현재값 + 이전 값;
                }
                map[i][j] = Arrays.stream(list).max().getAsInt();
            }
        }

        // 맵 확인
        /*for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/

        System.out.println(map[N][M]);
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 1 || nc < 1 || nr > N || nc > M;
    }
}
