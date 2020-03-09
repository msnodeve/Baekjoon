package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1726_로봇 {
    static HashMap<Integer, int[]> dirMap = new HashMap<>();
    static int rowN, colN, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][][] visit;
    static int[] startPos, endPos;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dirMap.put(1, new int[]{0, 1});
        dirMap.put(2, new int[]{0, -1});
        dirMap.put(3, new int[]{1, 0});
        dirMap.put(4, new int[]{-1, 0});

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        visit = new boolean[rowN][colN][5];
        for (int i = 0; i < rowN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        startPos = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), 0};
        st = new StringTokenizer(br.readLine());
        endPos = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), 0};
        // 처리
        bfs();

        // 출력
        System.out.println(result);
    }

    private static void bfs() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(startPos);
        visit[startPos[0]][startPos[1]][startPos[2]] = true;
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int row = loc[0];
            int col = loc[1];
            int curD = loc[2];
            int cnt = loc[3];

            if(row == endPos[0] && col == endPos[1] && curD == endPos[2]){
                result = Math.min(result,cnt);
            }

            // 1~3번까지 전진
            for (int i = 1; i <= 3; i++) {
                int[] nrc = dirMap.get(curD);
                int nr = row + nrc[0] * i;
                int nc = col + nrc[1] * i;
                // 범위를 벗어나거나 그자리가 벽이면 빠져나감
                if (nr < 0 || nc < 0 || nr >= rowN || nc >= colN || map[nr][nc] == 1) {
                    break;
                }
                if(visit[nr][nc][curD])
                    continue;
                queue.offer(new int[]{nr, nc, curD, cnt + 1});
                visit[nr][nc][curD] = true;
            }
            // 4방향 검사
            for (int d = 1; d <= 4; d++) {
                if(visit[row][col][d]) {
                    continue;
                }
                queue.offer(new int[]{row, col, d, cnt + checkDir(curD, d)});
                visit[row][col][d] = true;
            }
        }
    }

    private static int checkDir(int k, int i) {
        int[] cur = dirMap.get(k);
        int[] dir = dirMap.get(i);
        int c_x = cur[0];
        int c_y = cur[1];
        int d_x = dir[0];
        int d_y = dir[1];
        int div_x = Math.abs(c_x - d_x);
        int div_y = Math.abs(c_y - d_y);
        if (div_x == 0 && div_y == 0) {
            return 0;
        } else if (div_x == 2 || div_y == 2) {
            return 2;
        } else {
            return 1;
        }
    }
}
