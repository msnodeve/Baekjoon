package jungol.create_shape1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1856 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] arr = new int[n][m];
		int cnt = 1;
		
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++)
					arr[i][j] = cnt++;
			}
			else {
				for (int j = m - 1; j > -1; j--)
					arr[i][j] = cnt++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
