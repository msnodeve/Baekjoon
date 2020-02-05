package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution_1225_암호생성기_Solution_Buffered {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1225_암호생성기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int T = 10;
		int N = 8;

		for (int testcase = 1; testcase <= T; testcase++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			boolean isDone = false;
			top: while (!isDone) {
				for (int j = 1; j <= 5; j++) {
					int num = q.poll() - j;
					if (num <= 0) {
						num = 0;
						isDone = true;
					}
					q.offer(num);
					if (isDone) {
						break top;
					}
				}
			}

			// 출력
			System.out.print("#" + T + " ");
			for (int p : q) {
				System.out.print(p + " ");
			}
			System.out.println();
			q.clear();
		}
	}
}