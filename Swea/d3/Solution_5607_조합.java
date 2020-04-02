package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_5607_조합 {
    static int p = 1234567891;
    static long[] factorial;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            factorial = new long[N + 1];
            factorial[0] = 1;
            // factorial 구하기
            for (int i = 1; i <= N; i++) factorial[i] = (factorial[i - 1] * i) % p;
            long bottom = (factorial[R] * factorial[N - R]) % p; // r! * (n-r)! = B

            System.out.println("#" + testcase + " " + (divConquer(bottom, p - 2) * factorial[N]) % p);
        }
    }

    static long divConquer(long n, int x) {
        if (x == 0)
            return 1;
        long temp = divConquer(n, x / 2);
        long ret = (temp * temp) % p;
        if (x % 2 == 1)
            return (ret * n) % p;
        else
            return ret % p;
    }
}