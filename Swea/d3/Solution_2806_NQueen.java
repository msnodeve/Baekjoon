package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_2806_NQueen {
	static int result;
	static int N;
	static int[] cols;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/2806. N-Queen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			cols = new int[N];
			dfs(0);
			System.out.println("#" + testcase + " " + result);
		}
	
	}
	
	private static void dfs(int index) {
		if(index == N) {
			result++;
		}else {
			for (int i = 0; i < N; i++) {
				cols[index] = i;
				if(checkQueen(index)) {
					dfs(index+1);
				}
			}
		}
	}
	
	private static boolean checkQueen(int index) {
		for (int i = 0; i < index; i++) {
			if(cols[i] == cols[index] || Math.abs(index-i) == Math.abs(cols[index]-cols[i])) {
				return false;
			}
		}
		return true;
	}
}