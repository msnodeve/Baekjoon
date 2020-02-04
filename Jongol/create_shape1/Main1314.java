package jungol.create_shape1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1314 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] arr= new char[n][n];
		char cnt = 'A';
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ' ';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i, k = n-1; j < n && k > -1; j++, k--) {
				if (cnt == 'Z' + 1)
					cnt = 'A';
				arr[j][k] = cnt++;
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
