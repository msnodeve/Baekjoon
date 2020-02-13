package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1106_장기 {
	static int result;
	static int rowN, colN;
	static int horseR, horseC, jolR, jolC;
	static boolean[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1106_장기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowN = Integer.parseInt(st.nextToken());
		colN = Integer.parseInt(st.nextToken());
		map = new boolean[rowN][colN];
		visit = new boolean[rowN][colN];
		st = new StringTokenizer(br.readLine());
		horseR = Integer.parseInt(st.nextToken()) - 1;
		horseC = Integer.parseInt(st.nextToken()) - 1;
		jolR = Integer.parseInt(st.nextToken()) - 1;
		jolC = Integer.parseInt(st.nextToken()) - 1;

		bfs(horseR, horseC);
		
		System.out.println(result);
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		int cnt = 0;
		queue.offer(new int[] { r, c, cnt });
		visit[r][c] = true;
		
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			cnt = temp[2];
			cnt++;
			for (int i = 0; i < 8; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr > -1 && nc > -1 && nr < rowN && nc < colN) {
					if(nr == jolR && nc == jolC) {
						result = cnt;
						return;
					}
					if(!visit[nr][nc]) {
						queue.offer(new int[] {nr, nc, cnt});
						visit[nr][nc] = true;
					}
				}
			}
		}
	}
}
