package swea.d3;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

class Solution_1225_암호생성기_Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1225_암호생성기.txt"));
		Scanner scan = new Scanner(System.in);

		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < 10; i++) {
			// 입력
			int cnt = 1;
			// TestCase 번호
			int T = scan.nextInt();
			for (int j = 0; j < 8; j++) {
				q.offer(scan.nextInt());
			}

			// 처리
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
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
			q.clear();
		}
	}
}