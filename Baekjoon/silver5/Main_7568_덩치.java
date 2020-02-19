package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_7568_덩치 {
	static int[][] list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/7568_덩치.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		list = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int[] base = list[i];
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if(base[0] < list[j][0] && base[1] < list[j][1]) {
					cnt++;
				}
			}
			result.add(cnt);
		}
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}