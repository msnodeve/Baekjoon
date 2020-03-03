package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
    static int N, result = Integer.MAX_VALUE, temp = 0;
    static int[][] map;
    static boolean[] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리
        for (int i = 0; i < N; i++) {
            // 다시 돌아올 위치 설정
            temp = i;
            dfs(i, i, 0, 0);
        }

        // 출력
        System.out.println(result);
    }

    private static void dfs(int row, int col, int cnt, int sum) {
        // N번 돌고, 다시 원위치로 탐색왔다면
        if (cnt == N && temp == col) {
            result = Math.min(result, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i] && map[col][i] != 0 && sum + map[col][i] < result) {
                // 방문 체크
                visit[i] = true;
                dfs(col, i, cnt + 1, sum + map[col][i]);
                // 방문 언체크
                visit[i] = false;
            }
        }
    }
}
