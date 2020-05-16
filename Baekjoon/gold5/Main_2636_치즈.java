package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2636_치즈 {
    static int R, C;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Map 확인
        /*for(int[] row : map){
            System.out.println(Arrays.toString(row));
        }*/

        int time; // 시간 계산
        int result; // 마지막 치즈 결과 값
        for (time = 1; ; time++) {
            // 일단 치즈의 개수 파악
            result = getCheeses();

            // 치즈가 아직 살아 있다면
            if (result > 0)
                bfs(0, 0); // 바깥쪽은 항상 0이기 때문에 공기중에 노출되어있는 치즈 검사

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(visit[i][j]){ // 발견된 부분 죄다 0으로 만들어주기
                        map[i][j] = 0;
                    }
                }
            }
            // 발견된 치즈가 0개라면 그만
            if(getCheeses() == 0)
                break;
        }

        System.out.println(time);
        System.out.println(result);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visit = new boolean[R][C];
        visit[row][col] = true;
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            row = loc[0];
            col = loc[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                // 범위 밖으로 나갔으며, 이미 방문했다면 다음 탐색
                if(isOut(nr,nc) || visit[nr][nc])
                    continue;

                // 공기중이라면
                if(map[nr][nc] == 0){
                    queue.offer(new int[]{nr, nc});
                }
                visit[nr][nc] = true;
            }
        }
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= R || nc >= C;
    }

    // 치즈 개수 세루기
    static int getCheeses() {
        int cheese = 0;
        for (int[] row : map) {
            for (int i : row) {
                if (i == 1) {
                    cheese++;
                }
            }
        }
        return cheese;
    }
}