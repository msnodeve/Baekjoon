package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_1206_View {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1206_View.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int testcase = 1; testcase <= T; testcase++) {
			// 입력
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			int[] map = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			// 처리
			for (int i = 2; i < N - 2; i++) {
				int max = Integer.MAX_VALUE;
				for (int j = -2; j < 3; j++) {
					if (map[i] - map[i + j] < 0) {
						max = 0;
						break;
					} else {
						if (i != i + j) {
							if (map[i] - map[i + j] != 0) {
								if (map[i] - map[i + j] <= max) {
									max = map[i] - map[i + j];
								}
							} else {
								max = 0;
								break;
							}
						}
					}
				}
				result += max;
			}

			// 출력
			System.out.println("#" + testcase + " " + result);
		}
	}
}
