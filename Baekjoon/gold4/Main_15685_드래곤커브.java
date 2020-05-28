package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15685_드래곤커브 {
    static class Dragon {
        int x, y; // 끝점
        List<int[]> list; // 경로
        int rotateCnt; // 세대 회수

        public Dragon(int x, int y, int d, int rotateCnt) {
            this.rotateCnt = rotateCnt;
            this.list = new ArrayList<>();
            list.add(new int[]{x, y});
            switch (d) {
                case 0:
                    x++;
                    break;
                case 1:
                    y--;
                    break;
                case 2:
                    x--;
                    break;
                case 3:
                    y++;
                    break;
            }
            list.add(new int[]{x, y});
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Dragon{" +
                    "x=" + x +
                    ", y=" + y +
                    ", list=" + list +
                    ", rotateCnt=" + rotateCnt +
                    '}';
        }
    }

    static int N;
    static Dragon[] dragons;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        map = new boolean[101][101];
        N = Integer.parseInt(br.readLine());
        dragons = new Dragon[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dragons[i] = new Dragon(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 드래곤 커브 확인
        /*for (int i = 0; i < N; i++)
            System.out.println(dragons[i]);*/

        // 처리
        for (int i = 0; i < N; i++) {// 드래곤 커브 입력된 개수만큼 돌리기
            int rotateCnt = dragons[i].rotateCnt;
            for (int j = 0; j < rotateCnt; j++) { // 세대 회수만큼 돌리기
                // 끝점을 기준으로 90도씩 회전 시키기
                rotate(dragons[i]);
            }
        }

        // 드래곤 경로 확인
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < dragons[i].list.size(); j++) {
                System.out.print(Arrays.toString(dragons[i].list.get(j)));
            }
            System.out.println();
        }*/

        // 경로 칠하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < dragons[i].list.size(); j++) {
                int x = dragons[i].list.get(j)[0];
                int y = dragons[i].list.get(j)[1];
                if (x < 0 || y < 0 || x > 100 || y > 100)
                    continue;
                map[y][x] = true;
            }
        }

        // 4꼭짓점 확인
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
                    result++;
            }
        }

        // 출력
        System.out.println(result);
    }

    // 기준점으로 부터 90도 회전 시키는 함수
    private static void rotate(Dragon dragon) {
        int x = dragon.x;// 기준점
        int y = dragon.y;
        int size = dragon.list.size(); // 배열의 사이즈 만큼 돌리기
        for (int i = 0; i < size; i++) {
            // 여기서부터 기준좌표로부터 90도 회전 시작
            int dX = x - dragon.list.get(i)[0];
            int dY = y - dragon.list.get(i)[1];
            double rad = Math.abs(Math.toRadians(90));
            float cosD = (float) Math.cos(rad);
            float sinD = (float) Math.sin(rad);
            int inX = (int) (dX * cosD + dY * sinD);
            int inY = (int) (dY * cosD - dX * sinD);
            inX += x;
            inY += y;

            if (i == 0) { // 첫번째로 돌렸던 좌표는 끝좌표로 변경됨
                dragon.x = inX;
                dragon.y = inY;
            }
            dragon.list.add(new int[]{inX, inY});
        }
    }
}
