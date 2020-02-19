package baekjoon.bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_11050_이항계수1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int A = fact(N);
		int B = fact(K);
		int C = fact(N - K);

		B = B == 0 ? 1 : B;
		C = C == 0 ? 1 : C;

		System.out.println(A / (B * C));

	}

	private static int fact(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fact(n - 1) * n;
		}
	}
}
