package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
    static int R, C, max;
    static int[][] map;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맵 확인
        /*for(int[] row : map){
            System.out.println(Arrays.toString(row));
        }*/

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                checkType1(i, j, 0, 0);
                checkType2(i, j);
            }
        }

        System.out.println(max);
    }

    // ㅗ 모양 검사
    // 중심으로 부터 4방향 모든 날개를 검사 후 제일 작은 날개를 제거한 값을 구할것임
    private static void checkType2(int row, int col) {
        int wing = 4; // 초기 날개 개수
        int min = Integer.MAX_VALUE;
        int sum = map[row][col];

        for (int i = 0; i < 4; i++) { // 4방향 탐색
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            // 그 날개가 3이 미만이라면 이상한 모양이라는 뜻
            if(wing < 3)
                return;

            // 날개가 밖으로 삐져 나갔다면 날개 하나 감소
            if(isOut(nr, nc)) {
                wing--;
                continue;
            }

            min = Math.min(min, map[nr][nc]); // 4방향중 제일 작은 날개를 저장
            sum += map[nr][nc]; // 일단 중심이랑 모두 더함
        }

        // 날개가 4개 라면
        if(wing == 4){
            sum -= min;
        }
        // 날개가 3개 라면
        max = Math.max(max, sum);
    }

    // ㅁ, ㅣ, ㄴ, 번개 모양 검사
    private static void checkType1(int row, int col, int cnt, int sum) {
        if(cnt == 4){
            // 4번 파고 들어봤다면
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            // 범위 밖, 이미 방문했다면 다음 탐색
            if(isOut(nr, nc) || visit[nr][nc])
                continue;

            visit[nr][nc] = true;
            checkType1(nr, nc, cnt+1, sum + map[nr][nc]);
            visit[nr][nc] = false;
        }
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= R || nc >= C;
    }
}
