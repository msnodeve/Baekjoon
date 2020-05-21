package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_7206_숫자게임 {
    static int[] memo = new int[100000];
    static int result;
    static int number;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = 0;
            number = Integer.parseInt(br.readLine());

            System.out.println("#" + testcase + " " + dfs(number));
        }
    }

    private static int dfs(int num) {
        int ret = 0;
        if (memo[num] != 0) {
            return memo[num];
        }
        if (num < 10) {
            memo[num] = 0;
            return 0;
        }

        String value = String.valueOf(num);
        for (int i = 1; i < value.length(); i++) {
            int left = Integer.parseInt(value.substring(0, i));
            int right = Integer.parseInt(value.substring(i));
            ret = Math.max(ret, dfs(left * right));
        }
        if (value.length() > 2) { // 123 -> 1 / 2 / 3
            for (int i = 1; i < value.length(); i++) {
                for (int j = i + 1; j < value.length(); j++) {
                    int left = Integer.parseInt(value.substring(0, i)); // 1
                    int mid = Integer.parseInt(value.substring(i, j)); // 2
                    int right = Integer.parseInt(value.substring(j)); // 3
                    ret = Math.max(dfs(left * mid * right), ret);
                }
            }
        }

        memo[num] = ret + 1;
        return memo[num];
    }
}
