package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
    static int N;
    static int[] result; // -1, 0, 1 의 종이 개수
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[3]; // [0] => -1 개수, [1] => 0 개수, [2] => 1 개수,
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리
        divideConquer(N, 0, 0);

        // 출력
        for (int r : result){
            System.out.println(r);
        }
    }

    private static void divideConquer(int n, int front, int rear) {
        if (check(n, front, rear, map[front][rear])) {
            result[map[front][rear] + 1]++;
            return;
        } else {
            // 다르다면 9분할
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideConquer(n / 3, front + (n * i / 3), rear + (n * j / 3));
                }
            }
        }
    }

    private static boolean check(int n, int front, int rear, int kind) {
        for (int i = front; i < front + n; i++) {
            for (int j = rear; j < rear + n; j++) {
                if (kind != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
