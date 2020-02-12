package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Main_2667_단지번호붙이기 {
	static int no = 1;
	static int[][] map;
	static int[][] visit;
	static int N;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/2667_단지번호붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// 처리
		// 배열을 전체 순회하면서 아파트(1)을 찾으면 bfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) { // 아파트를 찾음
					bfs(i, j);
					no++;
				}
			}
		}
		// visit 배열을 순회하면서 단지마다 아파트 수 count
		int[] count = new int[no];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] > 0) { // 아파트를 찾음
					count[visit[i][j]]++;
				}
			}
		}

		// count 배열을 정렬해서
		Arrays.sort(count);
		
		// 출력
		System.out.println(--no);
		for (int i = 1; i <= no; i++) {
			System.out.println(count[i]);
		}
		
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visit[r][c] = no; // visit배열에 단지번호를 부여하면 방문처리가 됨
		queue.offer(new int[] { r, c });

		int[] cur;
		int nr, nc;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			r = cur[0];
			c = cur[1];
			for (int i = 0; i < 4; i++) { // 현재 아파트에 사방에 인접된 아파트가 있는지 확인
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > -1 && nc > -1 && nr < N && nc < N
						&& map[nr][nc] > 0
						&& visit[nr][nc] == 0) {
					visit[nr][nc] = no;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}

}
