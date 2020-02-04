package jungol.create_shape1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1307 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		char cnt = 'A';

		for (int i = n - 1; i > -1; i--) {
			for (int j = n - 1; j > -1; j--) {
				if (cnt == 'Z' + 1)
					cnt = 'A';
				arr[j][i] = cnt++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
