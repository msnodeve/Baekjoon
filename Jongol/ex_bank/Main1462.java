package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1462 {
	static int rowN, colN;
	static int max = 1;
	static char[][] map;
	static int[][] visit;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1462_보물섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력
		rowN = Integer.parseInt(st.nextToken());
		colN = Integer.parseInt(st.nextToken());
		map = new char[rowN][colN];
		visit = new int[rowN][colN];
		for (int i = 0; i < rowN; i++) {
			String line = br.readLine();
			for (int j = 0; j < colN; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// 처리
		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
					visit = new int[rowN][colN];
				}
			}
		}
		
		// 출력
		System.out.println(max);
	}

	private static void bfs(int r, int c) {
		int cnt = -1;
		LinkedList<int[]> queue = new LinkedList<>();
		// 현재 위치 부터 탐색하기위해 queue에 넣음
		queue.offer(new int[] { r, c, cnt });
		visit[r][c] = cnt;
		int[] nrc;
		// queue가 비어있지 않다면 계속 탐색
		while (!queue.isEmpty()) {
			nrc = queue.poll();
			r = nrc[0];
			c = nrc[1];
			cnt = nrc[2];
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr > -1 && nc > -1 && nr < rowN && nc < colN) {
					if (visit[nr][nc] == 0 && map[nr][nc] == 'L') {
						queue.offer(new int[] { nr, nc, cnt });
						visit[nr][nc] = cnt;
					}
				}
			}
		}
		max = Math.max(cnt, max);
	}
}
