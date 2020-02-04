package jungol.create_shape1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1339 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if (n % 2 == 1 && n > 0 && n < 101) {
			char[][] arr = new char[n][n];
			char cnt = 'A';

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = ' ';
				}
			}
			int c = 0;
			for (int i = n - 1; i > -1; i--) {
				if (i <= n / 2) {
					for (int j = i; j <= (n / 2) + c; j++) {
						if (cnt == 'Z' + 1)
							cnt = 'A';
						arr[j][i] = cnt++;
					}
					c++;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("INPUT ERROR");
		}
	}
}
