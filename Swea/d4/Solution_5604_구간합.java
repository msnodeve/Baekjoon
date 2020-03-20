package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5604_구간합 {
    static long A, B;
    static long[] result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());
            result = new long[10];

            // 처리
            solution(A, B);

            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += result[i] * i;
            }
            System.out.println("#" + testcase + " " + sum);
        }
    }

    private static void calc(long n, long cnt) {
        while (n > 0) {
            long div = n % 10L;
            result[(int)div] += cnt;
            n /= 10;
        }
    }

    private static void solution(long A, long B) {
        long cuttingCount = 10;
        long multiCount = 1;
        while (A!=B) {
            while (A % cuttingCount != 0) {
                calc(A++, multiCount);
                if (A == B){
                    calc(A, multiCount);
                    return;
                }
            }
            while (B % cuttingCount != 9) {
                calc(B--, multiCount);
                if(A-1 == B)
                    return;
            }
            for (int i = 0; i < 10; i++) {
                result[i] += ((B / cuttingCount) - (A / cuttingCount) + 1) * multiCount;
            }
            A /= 10L;
            B /= 10L;
            multiCount *= 10L;
        }
        if(A == B){
            calc(A, multiCount);
        }
    }
}
