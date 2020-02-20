package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int resultW, resultB;
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 처리
		div(0, 0, N - 1, N - 1);

		// 출력
		System.out.println(resultW);
		System.out.println(resultB);
	}

	private static void div(int sr, int sc, int er, int ec) {
		// 첫부분 검사 첫부분이
		int kind = map[sr][sc] == 1 ? 1 : 0;
		if (confirm(sr, sc, er, ec, kind)) {
			if(kind == 1) {
				resultB++;
			}else {
				resultW++;
			}
		} else {
			int midR = (sr + er) >> 1;
			int midC = (sc + ec) >> 1;
		
			// 4분할을 해야함
			div(sr, sc, midR, midC);
			div(sr, midC+1, midR, ec);
			div(midR+1, sc, er, midC);
			div(midR+1, midC+1, er, ec);
		}
	}

	private static boolean confirm(int sr, int sc, int er, int ec, int kind) {
		for (int i = sr; i <= er; i++) {
			for (int j = sc; j <= ec; j++) {
				if (map[i][j] != kind) {
					return false;
				}
			}
		}
		return true;
	}
}
