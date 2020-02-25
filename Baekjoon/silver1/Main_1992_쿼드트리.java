package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1992_쿼드트리 {
    static int N;
    static int[][] map;
    static StringBuilder result;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = br.read() - 48;
            }
            br.readLine();
        }

        // 처리
        divideConquer(N, 0, 0);

        // 출력
        System.out.println(result.toString());
    }

    private static void divideConquer(int n, int front, int rear) {
        if (check(n, front, rear, map[front][rear])) {
            if(map[front][rear] == 0){
                result.append("0");
            }else{
                result.append("1");
            }
            return;
        } else {
            // 다르다면 4분할 => 순서가 중요 1.왼쪽위 2.오른쪽위 3.왼쪽아래 4.오른쪽아래
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    divideConquer(n / 2, front + (n * i / 2), rear + (n * j / 2));
                }
            }
            result.append(")");
        }
    }

    private static boolean check(int n, int front, int rear, int kind) {
        for (int i = front; i < front + n; i++) {
            for (int j = rear; j < rear + n; j++) {
                if (kind != map[i][j]) {
                    result.append("(");
                    return false;
                }
            }
        }
        return true;
    }
}
