package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_3431_준환이의운동관리 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/3431_준환이의 운동관리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());

			int result = 0;
			int result1 = L - X;
			int result2 = U - X;

			if (result1 > 0) {
				result = result1;
			}
			if (result2 < 0) {
				result = -1;
			}

			System.out.println("#" + testcase + " " + result);
		}
	}
}