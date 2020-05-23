package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
    static int N;
    static int result;
    static int[] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            list = new int[N];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            solution(0, 0, 0);

            System.out.println("#" + testcase + " " + result);
        }
    }

    private static void solution(int step, int left, int right) {
        if (step == N) {
            result++;
            return;
        }

        for (int i = step; i < N; i++) {
            // 값 변경
            int temp = list[step];
            list[step] = list[i];
            list[i] = temp;

            solution(step + 1, left + list[step], right);
            if (left >= right + list[step])
                solution(step + 1, left, right + list[step]);

            // 복원
            temp = list[step];
            list[step] = list[i];
            list[i] = temp;
        }
    }
}
