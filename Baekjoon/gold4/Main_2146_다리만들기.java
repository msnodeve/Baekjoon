package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
    static int N, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리
        // 섬 번호 매기기
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    dfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        // 다리 놓기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    // 방문 배열 초기화
                    for (int k = 0; k < N; k++) {
                        Arrays.fill(visit[k], false);
                    }
                    bfs(i, j, map[i][j]);
                }
            }
        }

        // 출력
        System.out.println(result);
    }

    private static void bfs(int row, int col, int kind) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col, 0});
        visit[row][col] = true;
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            row = loc[0];
            col = loc[1];
            int cnt = loc[2];
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;
                if(map[nr][nc] != 0 && map[nr][nc] != kind){
                    result = Math.min(result, cnt-1);
                    return;
                }
                if(visit[nr][nc])
                    continue;
                if(map[nr][nc] == kind)
                    continue;
                if(map[nr][nc] == 0){
                    queue.offer(new int[]{nr,nc, cnt});
                    visit[nr][nc] = true;
                }
            }
        }
    }

    private static void dfs(int row, int col, int cnt) {
        visit[row][col] = true;
        map[row][col] = cnt;
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc] || map[nr][nc] == 0)
                continue;
            dfs(nr, nc, cnt);
        }
    }
}
