package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
    static int N, H, result;
    static int[][] map, temp;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        temp = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                H = Math.max(H, num);
            }
        }

        // 처리
        for (int h = 0; h <= H; h++) {
            // 0부터 장마 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = map[i][j] - h;
                    visit[i][j] = false;
                }
            }

            // temp 공간 dfs 로 검사
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && temp[i][j] > 0) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        // 출력
        System.out.println(result);
    }

    private static void dfs(int row, int col) {
        visit[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if (nr > -1 && nc > -1 && nr < N && nc < N) {
                if (!visit[nr][nc] && temp[nr][nc] > 0) {
                    visit[nr][nc] = true;
                    dfs(nr, nc);
                }
            }
        }
    }
}
