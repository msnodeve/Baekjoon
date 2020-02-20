package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution_2806_NQueen {
	static int result;
	static int N;
	static int[] cols;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/2806. N-Queen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			result = 0;
			cols = new int[N];
			dfs(0);
			System.out.println("#" + testcase + " " + result);
		}

	}

	private static void dfs(int cnt) {
		if (cnt == N) {
			result++;
		} else {
			for (int i = 0; i < N; i++) {
				// 현재 col에 Queen의 열 위치를 넣어본다.
				cols[cnt] = i;
				// 그 자리가 지금 놓을 수 있는 위치인지 확인한다.
				if (check(cnt)) {
					dfs(cnt + 1);
				}
			}
		}
	}

	private static boolean check(int cnt) {
		// 지금 cnt 열 위치 위쪽을 검사한다.
		// 검사는 같은 열인지, 대각선인지 검사한다.
		for (int i = 0; i < cnt; i++) {
			// 열이 같은지 확인하는 것
			if (cols[i] == cols[cnt])
				return false;
			// 대각선이 같은지 확인은 가로와 세로길이가 같은지 확인을 해야한다
			int rowlen = Math.abs(cnt - i); // 행의 길이
			int collen = Math.abs(cols[cnt] - cols[i]); // 열의 길이
			
			// 두개가 같다면 대각선에 있다는 의미
			if (rowlen == collen) {
				return false;
			}
		}
		return true;
	}

}