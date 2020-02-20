package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_7965_퀴즈 {
	static final int MOD = 1000000007;
	static int N;
	static long result;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/7965_퀴즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			result = 0;
			for (int i = 1; i <= N; i++) {
				result += dcPower(i, i) % MOD;
			}
			System.out.println("#" + testcase + " " + result % MOD);
		}

	}

	public static long dcPower(int x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		long ret = dcPower(x, n >> 1) % MOD;
		if (n % 2 == 0) {
			return (ret * ret) % MOD;
		} else {
			return (((ret * ret) % MOD) * x) % MOD;
		}
	}
}