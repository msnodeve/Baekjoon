package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7194_화섭이의미생물배양 {
    static long s, t, a, b, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Long.parseLong(st.nextToken());
            t = Long.parseLong(st.nextToken());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());

            if (b == 1) {
                if ((t - s) % a == 0)
                    result = (t - s) / a;
            } else
                dfs(t, 0);

            if (result == Integer.MAX_VALUE)
                System.out.println("#" + testcase + " " + -1);
            else
                System.out.println("#" + testcase + " " + result);

        }
    }

    private static void dfs(long n, int cnt) {
        if (n == s) {
            result = Math.min(result, cnt);
            return;
        }
        if (n < s) {
            return;
        }
        if (n % b == 0) {
            if (n / b < s) {
                dfs(n - a, cnt + 1);
            } else {
                dfs(n / b, cnt + 1);
            }
        } else {
            dfs(n - a, cnt + 1);
        }
    }
}
