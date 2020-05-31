package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1022_소용돌이예쁘게출력하기 {
    static int[][] map;
    static int r1, c1, r2, c2, max;
    static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        map = new int[r2 - r1 + 1][c2 - c1 + 1];

        draw();

        StringBuilder sb = new StringBuilder();
        int size = (int) Math.log10(max), len;
        for (int i = 0; i < r2 - r1 + 1; i++) {
            for (int j = 0; j < c2 - c1 + 1; j++) {
                len = size - (int)Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    sb.append(' ');
                }
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void draw() {
        int r = 0, c = 0, d = 0;
        int num = 1, dnum = 1, cnt = 0;

        while (!finish()) {
            // 범위 안에 들어온다면
            if (r >= r1 && r <= r2 && c >= c1 && c <= c2) {
                map[r - r1][c - c1] = num;
            }
            num++;
            cnt++;
            r += dir[d][0];
            c += dir[d][1];

            if (cnt == dnum) {
                cnt = 0;
                if (d == 1 || d == 3)
                    dnum++;
                d = (d + 1) % 4;
            }
        }
        max = num - 1;
    }

    private static boolean finish() {
        return map[0][0] != 0 && map[r2 - r1][0] != 0 && map[0][c2 - c1] != 0 && map[r2 - r1][c2 - c1] != 0;
    }
}
