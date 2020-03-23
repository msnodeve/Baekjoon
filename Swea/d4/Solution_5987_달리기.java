package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5987_달리기 {
    static int T, N, M;
    static int[] needs;
    static long[] memo;

    public static void main(String[] args) throws Exception {
        // 입력
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            int f, s;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            needs = new int[N];
            memo = new long[1<<N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                f = Integer.parseInt(st.nextToken()) - 1;
                s = Integer.parseInt(st.nextToken()) - 1;
                // 1, 10, 100, 1000 .. 로 들어감
                needs[f] |= (1 << s);
            }

            long r = dfs(0);
            System.out.println("#" + testcase + " " + r);
        }
    }

    private static long dfs(int flag) {
        if (flag == (1 << N) - 1) {
            return 1;
        }
        if(memo[flag] > 0){
            return memo[flag];
        }
        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) == 0) {
                if((flag & needs[i]) == needs[i]){
                    memo[flag] += dfs(flag | 1 << i);
                }
            }
        }
        return memo[flag];
    }
}