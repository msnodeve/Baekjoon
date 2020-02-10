package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution_1873_상호의_배틀필드 {
	static HashMap<Character, int[]> dirMap = new HashMap<>();
	static int curX, curY;
	static int n_x, n_y;
	static int H, W, N;
	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1873_상호의 배틀필드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			// 입력
			init();
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = (char) br.read();
					if (map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^' || map[i][j] == '<') {
						// 현재 전차의 위치
						curX = i;
						curY = j;
					}
				}
				br.readLine();
			}
			N = Integer.parseInt(br.readLine());

			// 처리
			for (int i = 0; i < N; i++) {
				n_x = curX;
				n_y = curY;
				switch ((char) br.read()) {
				case 'U':
					go('^');
					break;
				case 'D':
					go('v');
					break;
				case 'L':
					go('<');
					break;
				case 'R':
					go('>');
					break;
				case 'S':
					// 현재 방향
					n_x = curX;
					n_y = curY;
					while (true) {
						n_x += dirMap.get(map[curX][curY])[0];
						n_y += dirMap.get(map[curX][curY])[1];
						// 내부 라면
						if(n_x > -1 && n_x < H && n_y > -1 && n_y < W) {
							if(map[n_x][n_y] == '*') {
								map[n_x][n_y] = '.';
								break;
							}else if(map[n_x][n_y] == '#') {
								break;
							}
						}else {
							break;
						}
					}
					break;
				}
			}
			br.readLine();

			// 출력
			System.out.print("#" + testcase + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}
	public static void go(char input) {
		map[curX][curY] = input;
		n_x = curX + dirMap.get(map[curX][curY])[0];
		n_y = curY + dirMap.get(map[curX][curY])[1];
		if(n_x > -1 && n_x < H && n_y > -1 && n_y < W) {
			if(map[n_x][n_y] == '.') {
				map[curX][curY] = '.';
				map[n_x][n_y] = input;
				curX = n_x;
				curY = n_y;
			}
		}
	}
	public static void init() {
		dirMap.put('^', new int[] { -1, 0 });
		dirMap.put('>', new int[] { 0, 1 });
		dirMap.put('v', new int[] { 1, 0 });
		dirMap.put('<', new int[] { 0, -1 });
	}
}