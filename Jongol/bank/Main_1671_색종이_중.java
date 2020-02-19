package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1671_색종이_중 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] map = new int[102][102];
	static StringTokenizer st;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int paperX = Integer.parseInt(st.nextToken());
			int paperY = Integer.parseInt(st.nextToken());

			for (int j = paperX; j < paperX + 10; j++) {
				for (int j2 = paperY; j2 < paperY + 10; j2++) {
					map[j][j2] = 1;
				}
			}
		}

		// 처리
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (map[i][j] == 1) {
					for (int j2 = 0; j2 < 4; j2++) {
						int n_x = i + dir[j2][0];
						int n_y = j + dir[j2][1];
						if (n_x > -1 && n_x < 102 && n_y > -1 && n_y < 102 && map[n_x][n_y] == 0) {
							result++;
						}
					}

				}
			}
		}

		// 출력
		System.out.println(result);

	}

}
