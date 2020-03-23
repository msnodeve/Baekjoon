package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16927_배열돌리기2 {
    static int N, M, R, S;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        S = Math.min(N, M) / 2;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리
        // 사각형 나오는 개수 만큼 돌리기
        for (int s = 0; s < S; s++) {
            // 회수 만큼 회전
            // R을 계산해놓고 시작해야함
            int rR = R % (((N - 1 - s * 2) * 2) + ((M - 1 - s * 2) * 2));
            rR += 0;
            for (int r = 0; r < rR; r++) {

                int bottom = N - s - 1;
                int right = M - s - 1;

                int temp = map[s][s];
                // 상단 처리
                for (int i = s; i < right; i++) {
                    map[s][i] = map[s][i + 1];
                }
                // 우측 처리
                for (int i = s; i < bottom; i++) {
                    map[i][right] = map[i + 1][right];
                }
                // 하단 처리
                for (int i = right; i > s; i--) {
                    map[bottom][i] = map[bottom][i - 1];
                }
                // 좌측 처리
                for (int i = bottom; i > s; i--) {
                    map[i][s] = map[i - 1][s];
                }
                map[s + 1][s] = temp;
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
