package jungol.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1078_저글링방사능오염 {
	static int max;
	static int result;
	static int rowN, colN;
	static int radioR, radioC;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1078_저글링 방사능 오염.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());
		map = new int[rowN][colN];
		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				map[i][j] = br.read() - '0';
			}
			br.readLine();
		}
		st = new StringTokenizer(br.readLine());
		radioC = Integer.parseInt(st.nextToken()) - 1;
		radioR = Integer.parseInt(st.nextToken()) - 1;

		// 처리
		bfs(radioR, radioC, 3);
		result = checkJuggling();

		// 출력
		System.out.println(max);
		System.out.println(result);
	}

	private static void bfs(int r, int c, int cnt) {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, cnt });

		while (!queue.isEmpty()) {
			int[] location = queue.poll();
			map[r][c] = 0;
			r = location[0];
			c = location[1];
			cnt = location[2];

			max = Math.max(max, cnt);

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr > -1 && nc > -1 && nr < rowN && nc < colN && map[nr][nc] == 1) {
					map[nr][nc] = 0;
					queue.offer(new int[] { nr, nc, cnt + 1 });
				}
			}
		}
	}

	private static int checkJuggling() {
		int sum = 0;
		for (int[] i : map) {
			for (int j : i) {
				sum += j;
			}
		}
		return sum;
	}
}
