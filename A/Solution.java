package samsung01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Pos implements Comparable<Pos> {
		int val, key;

		public Pos(int val, int key) {
			super();
			this.val = val;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Pos [val=" + val + ", key=" + key + "]";
		}

		@Override
		public int compareTo(Pos o) {
			if (o.val == this.val) {
				return o.key - this.key;
			} else {
				return o.val - this.val;
			}
		}

	}

	static int deposit, monthMoney, tempD;
	static int kind, L;
	static int[][] table;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\samsung01\\sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tempD = deposit = Integer.parseInt(st.nextToken());
			monthMoney = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			kind = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			table = new int[kind][L + 2];
			for (int i = 0; i < kind; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j <= L; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 처리
			Queue<int[]> queue = new LinkedList<>();
			deposit -= monthMoney;
			for (int i = 0; i <= L; i++) {
				deposit += monthMoney;
				while (!queue.isEmpty()) {
					int[] cur = queue.poll();
					deposit += table[cur[0]][i] * cur[1];
				}
				PriorityQueue<Pos> pq = new PriorityQueue<>();
				for (int j = 0; j < kind; j++) {
					pq.offer(new Pos(table[j][i + 1] - table[j][i], j));
				}
				while (!pq.isEmpty()) {
					Pos pos = pq.poll();
					if (pos.val > 1) {
						int f = table[pos.key][i];
						int div = deposit / f;
						deposit -= div * f;
						queue.offer(new int[] { pos.key, div });
					}
				}
			}
			// 출력
			int result = deposit - (monthMoney * L) - tempD;
			System.out.println("#" + t + " " + result);
		}

	}
}
