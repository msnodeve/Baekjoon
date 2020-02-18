package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_2798_블랙잭 {
	static int N;
	static int M;
	static int result;
	static int[] arr;
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[3];
		list = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		combination(0, 0);
		System.out.println(result);
	}

	private static void combination(int start, int cnt) {
		if (cnt == 3) {
			int temp = 0;
			for (int i : arr) {
				temp += list[i];
			}
			if (temp <= M) {
				result = Math.max(temp, result);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			arr[cnt] = i;
			combination(i + 1, cnt + 1);
		}

	}
}
