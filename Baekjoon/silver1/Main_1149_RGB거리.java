package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

    static int[][] map;
    static int N, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        // 처리
        for (int i = 1; i < N; i++) {
            map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
            map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
            map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
        }
        result = Math.min(map[N-1][0], Math.min(map[N-1][1] , map[N-1][2]));

        // 출력
        System.out.println(result);
    }
}
