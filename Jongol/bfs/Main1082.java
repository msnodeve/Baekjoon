package jungol.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출 {
	static int R, C;
	static char[][] map;
	static int result;
	static LinkedList<int[]> queue;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1082_화염에서탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char temp = line.charAt(j);
				switch (temp) {
				case '*':
					queue.offer(new int[] { i, j, 0, });
					map[i][j] = temp;
					break;
				case 'S':
					queue.offerFirst(new int[] { i, j, 0 });
					map[i][j] = temp;
					break;
				default:
					map[i][j] = temp;
					break;
				}
			}
		}

		// 처리
		bfs();
		if (result != 0) {
			System.out.println(result);
		} else {
			System.out.println("impossible");
		}

	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] location = queue.poll();
			// queue에 들어있는 정보 가져오기
			int r = location[0];
			int c = location[1];
			int cnt = location[2];
			cnt++;
			
			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr > -1 && nc > -1 && nr < R && nc < C) {
					if (map[nr][nc] == 'D') { // 다음이 출구일때
						// 가져온 좌표가 S 인경우
						if (map[r][c] == 'S') {
							result = cnt;
							return;
						}
					} else if (map[nr][nc] == 'S') { // 다음이 S일때
						// 가져온 좌표가 * 인경우
						if (map[r][c] == '*') {
							map[nr][nc] = '*';
							queue.offer(new int[] { nr, nc, 0 });
						}
					} else if (map[nr][nc] == '.') { // 다음이 .일때
						if (map[r][c] == 'S') { // 가져온 좌표가 S 인경우
							map[nr][nc] = 'S';
							queue.offer(new int[] { nr, nc, cnt });
						} else if (map[r][c] == '*') {
							map[nr][nc] = '*';
							queue.offer(new int[] { nr, nc, 0 });
						}
					}
				}
			}
		}
	}
}
