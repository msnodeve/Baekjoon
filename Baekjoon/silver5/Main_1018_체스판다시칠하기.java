package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	static char[][] white;
	static char[][] black;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1018_체스판 다시 칠하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();

		
		int result = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}
		
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int a = Math.min(checkW(i, j), checkB(i,j));
				result = Math.min(a, result);
			}
		}
		
		System.out.println(result);
	}

	private static int checkW(int i, int j) {
		int cnt = 0;
		for (int k = i; k < i + 8; k++) {
			for (int h = j; h < j + 8; h++) {
				if(white[k-i][h-j] != map[k][h]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static int checkB(int i, int j) {
		int cnt = 0;
		for (int k = i; k < i + 8; k++) {
			for (int h = j; h < j + 8; h++) {
				if(black[k-i][h-j] != map[k][h]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void init() {
		white = new char[][] { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
		black = new char[][] { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
	}
}
