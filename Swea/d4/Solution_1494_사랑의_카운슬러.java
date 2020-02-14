package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_1494_사랑의_카운슬러 {

	static int N;
	static int[][] bug;
	static boolean[] visit;
	static long result;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1494_사랑의 카운슬러.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			result = Long.MAX_VALUE;
			bug = new int[N][2];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bug[i][0] = Integer.parseInt(st.nextToken());
				bug[i][1] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);
			
			System.out.println("#" + testcase + " " + result);			
		}
	}

	private static void dfs(int cur, int cnt) {
		if (cnt == N / 2) {
			long x =0;
			long y =0;
			for (int i = 0; i < N; i++) {
				if(visit[i]) {
					x += bug[i][0];
					y += bug[i][1];
				}else {
					x -= bug[i][0];
					y -= bug[i][1];
				}
			}

			result = Math.min(result, x*x+y*y);
			return;
		}

		for (int i = cur; i < N; i++) {
			if (visit[i]) {
				continue;
			}
			
			visit[i] = true;
			dfs(i+1, cnt+1);
			visit[i] = false;
		}
	}

}