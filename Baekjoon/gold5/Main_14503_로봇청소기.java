package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
    static class Cleaner {
        int row, col;
        int dirNum;

        public Cleaner(int row, int col, int dirNum) {
            this.row = row;
            this.col = col;
            this.dirNum = dirNum;
        }
    }

    static int R, C;
    static int[][] map;
    static Cleaner cleaner;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        st = new StringTokenizer(br.readLine());
        cleaner = new Cleaner(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 9)
                    result++;
            }
        }
        System.out.println(result);
    }

    private static void solution() {
        Queue<Cleaner> queue = new LinkedList<>();
        queue.offer(cleaner);
        map[cleaner.row][cleaner.col] = 9;

        while (!queue.isEmpty()) { // 청소기가 큐에 없을 때 까지 돌리기
            cleaner = queue.poll();
            int curR = cleaner.row;
            int curC = cleaner.col;
            int curD = cleaner.dirNum;

            boolean flag = false;
            int nextR, nextC, nextD;

            for (int i = 0; i < 4; i++) {
                curD = (curD + 3) % 4;
                nextR = curR + dir[curD][0];
                nextC = curC + dir[curD][1];

                Cleaner nextCleaner = new Cleaner(nextR, nextC, curD);

                if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C)
                    continue;

                if (map[nextR][nextC] == 0) {
                    queue.offer(nextCleaner);
                    map[nextR][nextC] = 9;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                nextD = (curD + 2) % 4;
                nextR = curR + dir[nextD][0];
                nextC = curC + dir[nextD][1];

                //만약 후진할 곳이 벽이 아니라면, 이동 그렇지 않다면 종료한다.
                if (map[nextR][nextC] != 1) {
                    map[nextR][nextC] = 9;
                    queue.add(new Cleaner(nextR, nextC, curD));
                }
            }
        }
    }
}
