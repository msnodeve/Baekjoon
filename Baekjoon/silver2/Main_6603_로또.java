package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또 {
    static int N, R;
    static int[] number, inputs;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        sb = new StringBuilder();
        R = 6;
        number = new int[R];
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            // N = 0이라면 종료 조건
            if (N == 0)
                break;

            inputs = new int[N];
            for (int i = 0; i < N; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }

            // 조합 시작
            combination(0, 0);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void combination(int cur, int cnt) {
        if (cnt == R) {
            for (int value : number)
                sb.append(value).append(' ');
            sb.append('\n');
            return;
        }
        for (int i = cur; i < N; i++) {
            number[cnt] = inputs[i];
            combination(i + 1, cnt + 1);
        }
    }
}
