package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class Solution_9940_순열1 {
    static int N;
    static int[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            visit = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                visit[Integer.parseInt(st.nextToken())]++;
            }

            System.out.println("#" + testcase + " " + (check() ? "Yes" : "No"));
        }

    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            if (visit[i] != 1)
                return false;
        }
        return true;
    }
}
