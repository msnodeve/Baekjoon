package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Ans {
	int height;
	int width;
	int weight;

	public Ans(int height, int width, int weight) {
		this.height = height;
		this.width = width;
		this.weight = weight;
	}
}

class Solution_1258_행렬찾기 {

	static int[][] map;
	static boolean[][] bMap;
	static int[][] dir = { { 1, 0 }, { 0, 1 } };
	static ArrayList<Ans> arr = new ArrayList<>();

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1258_행렬찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			// 입력
			arr = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			map = new int[N + 2][N + 2];
			bMap = new boolean[N + 2][N + 2];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 처리
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					int width = 1;
					int height = 1;
					if (!bMap[i][j] && map[i][j] != 0) {
						int n_x = i;
						int n_y = j;
						while (true) {
							n_x += dir[0][0];
							n_y += dir[0][1];
							if (map[n_x][n_y] != 0) {
								height++;
							} else {
								break;
							}
						}
						n_x = i;
						n_y = j;
						while (true) {
							n_x += dir[1][0];
							n_y += dir[1][1];
							if (map[n_x][n_y] != 0) {
								width++;
							} else {
								break;
							}
						}
						arr.add(new Ans(height, width, height * width));
						for (int k = i; k < i + height; k++) {
							for (int k2 = j; k2 < j + width; k2++) {
								bMap[k][k2] = true;
							}
						}
					}
					bMap[i][j] = true;
				}
			}
			Collections.sort(arr, new Comparator<Ans>() {
				@Override
				public int compare(Ans o1, Ans o2) {
					return o2.width - o1.width;
				}
			});
			Collections.sort(arr, new Comparator<Ans>() {
				@Override
				public int compare(Ans o1, Ans o2) {
					return o1.weight - o2.weight;
				}
			});
			
			// 출력
			System.out.print("#" + testcase + " " + arr.size() + " ");
			for (Ans a : arr) {
				System.out.print(a.height + " " + a.width + " ");
			}
			System.out.println();
		}
	}
}