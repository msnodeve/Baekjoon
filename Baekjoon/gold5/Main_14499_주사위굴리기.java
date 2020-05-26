package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
    static class Dice {
        int row, col;
        int forBound, forSky, forEast, forWest, forSouth, forNorth; // 땅, 하늘, 동, 서, 남, 북

        public Dice(int row, int col, int forBound, int forSky, int forEast, int forWest, int forSouth, int forNorth) {
            this.row = row;
            this.col = col;
            this.forBound = forBound;
            this.forSky = forSky;
            this.forEast = forEast;
            this.forWest = forWest;
            this.forSouth = forSouth;
            this.forNorth = forNorth;
        }

        public void rotate(int dir) {
            int temp;
            switch (dir) {
                case 1: // 동쪽으로 이동했을 때
                    temp = forBound;
                    forBound = forEast;
                    forEast = forSky;
                    forSky = forWest;
                    forWest = temp;
                    break;
                case 2: // 서쪽으로 이동했을 때
                    temp =  forBound;
                    forBound = forWest;
                    forWest = forSky;
                    forSky = forEast;
                    forEast = temp;
                    break;
                case 3: // 북쪽으로 이동했을 때
                    temp = forBound;
                    forBound = forNorth;
                    forNorth = forSky;
                    forSky = forSouth;
                    forSouth = temp;
                    break;
                case 4: // 남쪽으로 이동했을 때
                    temp = forBound;
                    forBound = forSouth;
                    forSouth = forSky;
                    forSky = forNorth;
                    forNorth = temp;
                    break;
            }
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int R, C, K;
    static int[] route;
    static int[][] map;
    static Dice dice;
    static int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dice = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, 0, 0, 0, 0, 0);
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        route = new int[K];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        // 맵, 경로 확인
        /*for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(Arrays.toString(route));*/

        solution();

        System.out.println(sb.toString());
    }

    private static void solution() {
        for (int i = 0; i < K; i++) { // 명령 회수만큼 돌기

            // 현재 명령의 방향으로 다음 방향 확인
            int nr = dice.row + dir[route[i]][0];
            int nc = dice.col + dir[route[i]][1];

            // 범위 밖이면 해당 명령어 무시
            if (isOut(nr, nc))
                continue;

            // 범위 밖이 아니라면 이동
            dice.row += dir[route[i]][0];
            dice.col += dir[route[i]][1];
            dice.rotate(route[i]);

            // 바닥이 0인 경우
            if(map[nr][nc] == 0){
                map[nr][nc] =dice.forBound; // 주사위 -> 바닥
            }else{ // 0이 아닌경우
                dice.forBound = map[nr][nc]; // 바닥 -> 주사위 -> 바닥(0)
                map[nr][nc] = 0;
            }

            sb.append(dice.forSky).append('\n');
        }
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= R || nc >= C;
    }
}