package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
    static int rowN, colN, result = -1;
    static LinkedList<int[]> queue = new LinkedList<>();
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        map = new char[rowN][colN];
        visit = new boolean[rowN][colN];
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                char index = (char) br.read();
                map[i][j] = index;
                switch (index) {
                    case '*':
                        queue.offer(new int[]{i, j, 0});
                        visit[i][j] = true;
                        break;
                    case 'S':
                        queue.offerFirst(new int[]{i, j, 0});
                        visit[i][j] = true;
                        break;
                }
            }
            br.readLine();
        }

        // 처리
        bfs();

        // 출력
        if(result == -1){
            System.out.println("KAKTUS");
        }else {
            System.out.println(result);
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int curR = loc[0];
            int curC = loc[1];
            for (int i = 0; i < 4; i++) {
                int nr = curR + dir[i][0];
                int nc = curC + dir[i][1];
                if (nr > -1 && nc > -1 && nr < rowN && nc < colN) {
                    // 현재 위치가 고슴도치라면
                    if (map[curR][curC] == 'S') {
                        // 현재 고슴도치인데, 다음지역이 비버굴이라면 도착
                        if (map[nr][nc] == 'D') {
                            result = loc[2]+1;
                            return;
                        }
                        // 다음 지역을 방문하지 않았으며, 비어있는 공간이라면
                        if (!visit[nr][nc] && map[nr][nc] == '.') {
                            queue.offer(new int[]{nr, nc, loc[2] + 1});
                            map[nr][nc] = 'S';
                            visit[nr][nc] = true;
                        }
                    }
                    // 현재 위치가 물이라면
                    else if (map[curR][curC] == '*') {
                        // 위치가 고슴 도치라면
                        if (map[nr][nc] == 'S') {
                            queue.offer(new int[]{nr, nc, 0});
                            map[nr][nc] = '*';
                            visit[nr][nc] = true;
                        }
                        // 다음 지역을 방문하지 않았으며, 벽이 아니라면
                        if (!visit[nr][nc] && map[nr][nc] != 'X' && map[nr][nc] != 'D') {
                            queue.offer(new int[]{nr, nc, 0});
                            map[nr][nc] = '*';
                            visit[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
}
