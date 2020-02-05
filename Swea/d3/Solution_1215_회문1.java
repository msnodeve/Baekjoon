package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_1215_회문1 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1215_회문1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		int N = 8;
		String[][] arr = new String[N][N];
		for (int i = 1; i <= T; i++) {
			// 입력
			int result = 0;
			int palindrome = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				String[] line = br.readLine().split("");
				for (int k = 0; k < N; k++) {
					arr[j][k] = line[k];
				}
			}
			
			
			// 처리
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N - palindrome + 1; k++) {
					String row = "";
					for (int k2 = 0; k2 < palindrome; k2++) {
							row += arr[j][k+ k2];
					}
					if(new StringBuffer(row).reverse().toString().equals(row)) {
						result++;
					}
				}
			}
			for (int j = 0; j < N - palindrome + 1; j++) {
				for (int k = 0; k < N ; k++) {
					String col = "";
					for (int k2 = 0; k2 < palindrome; k2++) {
							col += arr[j+k2][k];
					}
					if(new StringBuffer(col).reverse().toString().equals(col)) {
						result++;
					}
				}
			}
			
			// 출력
			System.out.println("#"+i + " " + result);
		}
	}
}