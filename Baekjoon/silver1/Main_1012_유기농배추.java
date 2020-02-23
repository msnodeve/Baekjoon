package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
    static int rowN, colN;
    static int result;
    static int[][] visit;
    static int[][] map;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            colN = Integer.parseInt(st.nextToken());
            rowN = Integer.parseInt(st.nextToken());
            map = new int[rowN][colN];
            visit = new int[rowN][colN];
            int beanN = Integer.parseInt(st.nextToken());

            for (int bean = 0; bean < beanN; bean++) {
                st = new StringTokenizer(br.readLine());
                int b_c = Integer.parseInt(st.nextToken());
                int b_r = Integer.parseInt(st.nextToken());
                map[b_r][b_c] = 1;
            }

            // 처리
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    if (map[i][j] == 1 && visit[i][j] == 0) {
                        bfs(i, j);
                        result++;
                    }
                }
            }

            // 출력
            System.out.println(result-1);
        }
    }

    private static void bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visit[row][col] = result;

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            row = location[0];
            col = location[1];
            for (int i = 0; i < 4; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];
                if (nr > -1 && nc > -1 && nr < rowN && nc < colN && map[nr][nc] == 1 && visit[nr][nc] == 0) {
                    queue.offer(new int[]{nr, nc});
                    visit[nr][nc] = result;
                }
            }
        }
    }
}
