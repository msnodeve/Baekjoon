package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2174_로봇시뮬레이션 {
    static class Robot {
        int row, col;
        int curDirection;

        public Robot(int row, int col, int curDirection) {
            this.row = row;
            this.col = col;
            this.curDirection = curDirection;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "row=" + row +
                    ", col=" + col +
                    ", curDirection=" + curDirection +
                    '}';
        }
    }
    static BufferedReader br;
    static StringTokenizer st;
    static int R, C, N, M;
    static int[][] map;
    static Robot[] robots;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken()) + 1;
        R = Integer.parseInt(st.nextToken()) + 1;
        map = new int[R][C];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        robots = new Robot[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = getDirection(st.nextToken().charAt(0));
            robots[i] = new Robot(r, c, d);
            map[r][c] = i;
        }

        // 맵 확인
        /*for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/

        // 처리 및 출력
        System.out.println(solution());
    }

    private static String solution() throws Exception {
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNumber = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            // 만약 command 가 L 또는 R 일때, repeat % 4를 해준다.(1번, 5번, 9번은 똑같은 방향이기 때문에)
            if(command == 'R' || command == 'L'){
                repeat %= 4;
            }

            // 수행해야할 로봇
            Robot robot = robots[robotNumber];

            // 명령의 반복 회수만큼 돌리기
            for (int repeatCount = 0; repeatCount < repeat; repeatCount++) {
                map[robot.row][robot.col] = 0; // 1. 해당자리 비우기

                if(command == 'F'){ // 앞으로 가기
                    int nr = robot.row + dir[robot.curDirection][0];
                    int nc = robot.col + dir[robot.curDirection][1];
                    if(isOut(nr, nc)){ // 벽을 만났다면
                        return "Robot " + robotNumber + " crashes into the wall";
                    }
                    if(map[nr][nc] != 0){ // 로봇을 만났다면
                        return "Robot " + robotNumber + " crashes into robot " + map[nr][nc];
                    }
                    // 다음 좌표로 이동
                    robot.row = nr;
                    robot.col = nc;
                }
                else if(command == 'R') // 왼쪽으로 돌리기
                    robot.curDirection = (robot.curDirection + 3) % 4;
                else if(command == 'L') // 오른쪽으로 돌리기
                    robot.curDirection = (robot.curDirection + 1) % 4;

                map[robot.row][robot.col] = robotNumber; // 2. 해당자리 번호 주기
            }
        }
        return "OK";
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 1 || nc < 1 || nr >= R || nc >= C;
    }

    private static int getDirection(char d) {
        switch (d) {
            case 'S':
                return 0;
            case 'E':
                return 1;
            case 'N':
                return 2;
            case 'W':
                return 3;
        }
        return 0;
    }
}
