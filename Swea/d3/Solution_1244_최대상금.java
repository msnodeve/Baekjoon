package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_1244_최대상금 {
	static int N;
	static char[] nums;
	static int result;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1244_최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			nums = num.toCharArray();
			N = Integer.parseInt(st.nextToken());
			// 처리

			dfs(0, 0);

			System.out.println("#" + testcase + " " + result);
		}
	}

	private static void dfs(int cur, int cnt) {
		if (cnt == N) {
			result = Math.max(result, Integer.parseInt(new String(nums)));
			return;
		}

		for (int i = cur; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				swap(i, j);
				dfs(i, cnt + 1);
				swap(i, j);
			}
		}
	}

	private static void swap(int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}