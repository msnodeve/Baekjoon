package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4530_극한의청소작업 {
    static long A, B;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            long absA = Math.abs(A);
            long absB = Math.abs(B);
            long a = changeTenBit(changeNineBit(absA));
            long b = changeTenBit(changeNineBit(absB));

            if (A < 0 && B > 0) {
                System.out.println("#" + testcase + " " + (a + b - 1));
            } else if(A > 0 && B > 0) {
                System.out.println("#" + testcase + " " + (b - a));
            }else if (A < 0 && B < 0) {
                System.out.println("#" + testcase + " " + (a - b));
            } else {
                System.out.println("#" + testcase + " " + (a + b));
            }
        }
    }

    private static long changeNineBit(long n) {
        char[] num = String.valueOf(n).toCharArray();
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= '4') {
                num[i] = (char) (num[i] - 1);
            }
        }
        return Long.parseLong(String.valueOf(num));
    }

    private static long changeTenBit(long n) {
        long cnt = 1;
        long result = 0;
        char[] num = String.valueOf(n).toCharArray();
        for (int i = num.length - 1; i > -1; i--) {
            result += cnt * (num[i] - '0');
            cnt *= 9;
        }
        return result;
    }
}
