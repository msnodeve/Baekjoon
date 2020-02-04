package jungol.create_shape1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2046 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]); // 배열 크기
		int m = Integer.parseInt(s[1]); // 번호

		int[][] arr = new int[n][n];

		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = i+1;
				}
			}
			break;
		case 2:
			int cnt = 1;
			for (int i = 0; i < n; i++) {
				cnt = 1;
				if (i % 2 == 0)
					for (int j = 0; j < n; j++) {
						arr[i][j] = cnt++;
					}
				else
					for (int j = n - 1; j > -1; j--) {
						arr[i][j] = cnt++;
					}
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = (i+1) * (j+1);
				}
			}
			break;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
