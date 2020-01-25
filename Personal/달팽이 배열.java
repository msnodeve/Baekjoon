import java.util.Scanner;
import java.io.FileInputStream;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (int test_case = 1; test_case <= T; test_case++) {
			// 배열의 크기
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int cnt = 1;
			int d = 0;
			int x = 0;
			int y = 0;
			map[x][y] = cnt++;
			for (int i = 0; i < N * N -1; i++) {
				x = x + dir[d][0];
				y = y + dir[d][1];
				if (x > -1 && x < N && y > -1 && y < N) {
					if (map[x][y] == 0) {
						map[x][y] = cnt++;
					} else {
						x = x - dir[d][0];
						y = y - dir[d][1];
						d++;
						if (d == 4) {
							d = 0;
						}
						x = x + dir[d][0];
						y = y + dir[d][1];
						map[x][y] = cnt++;
					}
				} else {
					x = x - dir[d][0];
					y = y - dir[d][1];
					d++;
					if (d == 4) {
						d = 0;
					}
					x = x + dir[d][0];
					y = y + dir[d][1];
					map[x][y] = cnt++;
				}
			}

			System.out.println("#"+test_case);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}