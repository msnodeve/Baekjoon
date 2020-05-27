package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3190_뱀 {
    static class Snake {
        int row, col; // 뱀의 위치

        public Snake(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, K, L;
    static List<int[]> dList; // 뱀의 이동방향
    static int[][] map;
    static boolean[][] visit;
    static Queue<Snake> queue;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1; // 사과의 위치를 저장
        }
        L = Integer.parseInt(br.readLine());
        dList = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            dList.add(new int[]{Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)});
        }
        // 맵, 경로 확인
        /*for (int[] row : map)
            System.out.println(Arrays.toString(row));
        for (int[] d : dList)
            System.out.println(Arrays.toString(d));*/

        System.out.println(solution());
    }

    private static int solution() {
        queue = new LinkedList<>();
        queue.offer(new Snake(0, 0)); // 뱀의 위치 [0, 0] 시작
        visit[0][0] = true;
        int curD = 1;
        int change = 0;
        int[] changeDirection = dList.get(change);
        int row = 0, col = 0;

        for (int time = 0; ; time++) {
            if (changeDirection[0] == time) { // 바뀌어야 할 시간이 넘어섰다면
                switch (changeDirection[1]) {
                    case 'D': // 오른쪽으로 꺾기
                        curD = (curD + 1) % 4;
                        break;
                    case 'L': // 왼쪽으로 꺾기
                        curD = (curD + 3) % 4;
                        break;
                }
                if (change + 1 < L)
                    changeDirection = dList.get(++change);
            }

            // 다음 방향 탐색
            int nr = row + dir[curD][0];
            int nc = col + dir[curD][1];

            // 범위 밖으로 나갔으며, 자신의 몸에 부딪혔다면
            if (isOut(nr, nc) || visit[nr][nc])
                return time + 1;

            // 그렇지 않고, 다음 위치가 사과가 있다면
            if (map[nr][nc] == 1) {
                map[nr][nc] = 0; // 사과 없애기
            } else {
                Snake tail = queue.poll();
                visit[tail.row][tail.col] = false; // 그 위치 없애기
            }
            visit[nr][nc] = true; // 방문 체크
            row += dir[curD][0]; // 머리를 다음 위치로 옮기기
            col += dir[curD][1];
            queue.offer(new Snake(nr, nc)); // 머리 넣기
        }
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= N || nc >= N;
    }
}
