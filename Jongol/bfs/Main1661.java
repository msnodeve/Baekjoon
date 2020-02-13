package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1661 {
	static int N;
	static int[][] map;
	static int rowN, colN;
	static int scol, srow, ecol, erow;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int startC, startR, endR, endC; // 출발 위치, 도착 위치

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1661_미로 탈출 로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		// 배열 선언시 => 좌표 1~N 보정
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());
		map = new int[rowN][colN];
		st = new StringTokenizer(br.readLine().trim(), " ");
		scol = Integer.parseInt(st.nextToken());
		srow = Integer.parseInt(st.nextToken());
		ecol = Integer.parseInt(st.nextToken());
		erow = Integer.parseInt(st.nextToken());

		// 공백 x - '0'
		for (int i = 0; i < rowN; i++) {
			String line = br.readLine().trim();
			for (int j = 0; j < colN; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		// bfs
		bfs();
		for (int i = 0; i < rowN; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		System.out.println(map[erow-1][ecol-1] - 1);
	}

	private static void bfs() {
		// 1. 시작점 방문표시 1, 큐에 넣기
		int nr, nc, t, r, c;
		int[] temp;
		LinkedList<int[]> queue = new LinkedList<>();
		map[srow][scol] = 1;
		queue.offer(new int[] { srow, scol });
		
		// 2. 큐가 empty가 아닐때 까지 반복
		while (!queue.isEmpty()) {
			// 3. 큐에서 데이터 추출 r, c, t
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			t = map[r][c];

			// 4. 인접처리 => 4방향 검색
			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];
				// 5. 경계검사, 갈수 있는 길인지 map[nr][nc] == 0 <= 방문 검사까지 함
				if (nr > -1 && nc > -1 && nr < rowN && nr < colN && map[nr][nc] == 0) {
					map[nr][nc] = t+1;
					// 6. 갈수 있다면 nr, nc가 도착인지 확인
					// 7. 도착했으면 return, break;
					if (nr == erow && nc == ecol) {
						return;
					}
					// 8. 갈수 없다면 nr, nc를 큐에 넣는다
					else {
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}

}
