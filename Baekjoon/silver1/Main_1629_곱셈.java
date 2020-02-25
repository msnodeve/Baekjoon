package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_곱셈 {
    static int A, B, C;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 처리 및 출력
        System.out.println(divideConquer(A, B) % C);
    }

    private static long divideConquer(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long result = divideConquer(a, b >> 1) % C;
        if (b % 2 == 0) {
            return (result * result) % C;
        } else {
            return ((result * result) % C * a) % C;
        }
    }
}
