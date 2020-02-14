package baekjoon.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int rowN, colN;
	static int result;
	static char[][] map;
	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/3109_빵집.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력
		rowN = Integer.parseInt(st.nextToken());
		colN = Integer.parseInt(st.nextToken());
		map = new char[rowN][colN];
		for (int i = 0; i < rowN; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 처리
		for (int i = 0; i < rowN; i++) {
			dfs(i, 0);
		}

		// 출력
		System.out.println(result);
	}

	private static boolean dfs(int r, int c) {
		if (c == colN - 1) {
			result++;
			return true;
		}
		map[r][c] = 'x';
		for (int i = 0; i < 3; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr > -1 && nr < rowN && nc < colN && map[nr][nc] == '.') {
				boolean checkEnd = dfs(nr, nc); 
				if(checkEnd) {
					return true;
				}
			}
		}
		return false;
	}
}
