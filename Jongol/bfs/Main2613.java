package jungol.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main_7576_토마토 {
	static int[][] map;
	static int rowN, colN;
	static LinkedList<int[]> globalQueue = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/7576_토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());

		map = new int[rowN][colN];
		for (int i = 0; i < rowN; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < colN; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 처리
		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				if (map[i][j] == 1) {
					globalQueue.offer(new int[] { i, j, 0 });
					map[i][j] = -1;
				}
			}
		}
		int cnt = 0;
		while (!globalQueue.isEmpty()) {
			int[] location = globalQueue.poll();

			int c_r = location[0];
			int c_c = location[1];
			cnt = location[2];
			for (int i = 0; i < 4; i++) {
				int nr = c_r + dir[i][0];
				int nc = c_c + dir[i][1];
				if (nr > -1 && nc > -1 && nr < rowN && nc < colN && map[nr][nc] == 0) {
					globalQueue.offer(new int[] { nr, nc, cnt+1 });
					map[nr][nc] = -1;
				}
			}
		}

		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				if (map[i][j] == 0) {
					cnt = -1;
				}
			}
		}

		System.out.println(cnt);
	}
}
