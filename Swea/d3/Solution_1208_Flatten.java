package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_1208_Flatten {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1208_Flatten.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int testcase = 1; testcase <= T; testcase++) {
			// 입력
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int maxIndex = 0;
			int minIndex = 0;
			int result = 0;
			int N = 100;
			int[] map = new int[N];
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			// 처리
			for (int i = 1; i <= dump; i++) {
				for (int j = 0; j < N; j++) {
					int temp = map[j];
					if(max < temp) {
						max = temp;
						maxIndex = j;
					}
					if(min > temp) {
						min = temp;
						minIndex = j;
					}
				}
				max = --map[maxIndex];
				min = ++map[minIndex];
			}
			result = Arrays.stream(map).max().getAsInt() - Arrays.stream(map).min().getAsInt();
			
			// 출력
			System.out.println("#" + testcase + " " + result);
		}
	}
}
