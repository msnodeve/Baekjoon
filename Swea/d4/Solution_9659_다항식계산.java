package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9659_다항식계산 {
    static final long MOD = 998244353;
    static int N, M;
    static int[] t, a, b;
    static long[] f;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testcase = 1; testcase <= T; testcase++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            t = new int[N + 1];
            a = new int[N + 1];
            b = new int[N + 1];
            f = new long[N + 1];
            for (int i = 2; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken());
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                f[0] = 1;
                f[1] = num;
                for (int j = 2; j <= N; j++) {
                    if (t[j] == 1)
                        f[j] = (f[a[j]] + f[b[j]]) % MOD;
                    else if (t[j] == 2)
                        f[j] = (a[j] * f[b[j]]) % MOD;
                    else if (t[j] == 3)
                        f[j] = (f[a[j]] * f[b[j]]) % MOD;
                }
                sb.append(f[N]).append(' ');
            }
            System.out.println("#" + testcase + " " + sb);
        }
    }
}
