package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {

    static int[] bettleCase1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] bettleCase2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    static int[][] map, result;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[6][3];
        result = new int[6][3];
        ans = new int[4];

        for (int testCase = 0; testCase < 4; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(testCase, 0);
        }

        for (int i : ans) {
            System.out.print(i+" ");
        }
    }

    private static void dfs(int testCase, int cnt) {
        if (cnt == 15) {
            if (ans[testCase] != 1) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (map[i][j] != result[i][j])
                            return;
                    }
                }
                ans[testCase] = 1;
            }
            return;
        }

        int team1 = bettleCase1[cnt];
        int team2 = bettleCase2[cnt];

        result[team1][0]++;
        result[team2][2]++;
        dfs(testCase, cnt + 1);
        result[team1][0]--;
        result[team2][2]--;

        result[team1][2]++;
        result[team2][0]++;
        dfs(testCase, cnt + 1);
        result[team1][2]--;
        result[team2][0]--;

        result[team1][1]++;
        result[team2][1]++;
        dfs(testCase, cnt + 1);
        result[team1][1]--;
        result[team2][1]--;

    }
}