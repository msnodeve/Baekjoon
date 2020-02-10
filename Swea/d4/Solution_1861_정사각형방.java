package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution_1861_정사각형방 {
	static class XY {
		int xy;
		int v;
		public XY(int xy, int v) {
			this.xy = xy;
			this.v = v;
		}
	}

	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1861_정사각형 방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<XY> arr;
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			// 입력
			int result = 1;
			int value = Integer.MAX_VALUE;
			arr = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 처리
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 현재 위치 부터 탐색 시작
					int curX = i;
					int curY = j;
					int tempResult = 1;
					while (true) {
						int k = 0;
						for (k = 0; k < 4; k++) {
							int n_x = curX + dir[k][0];
							int n_y = curY + dir[k][1];
							if (n_x > -1 && n_x < N && n_y > -1 && n_y < N) {
								if (map[n_x][n_y] == map[curX][curY] + 1) {
									curX = n_x;
									curY = n_y;
									tempResult++;
									break;
								}
							}
						}
						if (k >= 4) {
							if (result <= tempResult) {
								result = tempResult;
								arr.add(new XY(map[i][j], result));
							}
							break;
						}
					}
				}
			}
			int temp = 0;
			for (int i = 0; i < arr.size(); i++) {
				if(temp < arr.get(i).v) {
					temp = arr.get(i).v;
				}
			}
			for (int i = 0; i < arr.size(); i++) {
				if(temp == arr.get(i).v) {
					value = Math.min(value, arr.get(i).xy);
				}
			}
			
			
			// 출력
			System.out.println("#" + testcase + " " + value + " " + result);

		}
	}
}