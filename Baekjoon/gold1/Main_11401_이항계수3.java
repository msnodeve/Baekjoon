package gold1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11401_이항계수3 {
    static int p = 1000000007;
    static long[] factorial;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        factorial = new long[N + 1];
        factorial[0] = 1;
        // factorial 구하기
        for (int i = 1; i <= N; i++) factorial[i] = (factorial[i - 1] * i) % p;
        long bottom = (factorial[R] * factorial[N - R]) % p; // r! * (n-r)! = B

        System.out.println((divConquer(bottom, p - 2) * factorial[N]) % p);

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
