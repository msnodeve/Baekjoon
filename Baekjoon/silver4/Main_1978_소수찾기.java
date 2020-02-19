package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_1978_소수찾기 {
	static int N;
	static int[] listN;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		N = Integer.parseInt(br.readLine());
		listN = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			listN[i] = Integer.parseInt(st.nextToken());
		}
		
		// 처리
		int cnt = 0;
		for (int k : listN) {
			boolean flag = false;
			if (k != 1) {
				for (int i = 2; i < k; i++) {
					if (k % i == 0) {
						flag = true;
						break;
					}
				}
				if (!flag)
					cnt++;
			}
		}

		// 출력
		System.out.println(cnt);
	}

}
