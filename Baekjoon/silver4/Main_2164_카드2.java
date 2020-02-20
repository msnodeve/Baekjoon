package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main_2164_카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		boolean flag = false;
		LinkedList<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		// 처리
		while (queue.size() != 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		// 출력
		System.out.println(queue.poll());
	}

}
