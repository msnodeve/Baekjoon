package jungol.create_shape1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1304 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int cnt = 1;
		
		for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					arr[j][i] = cnt++;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
