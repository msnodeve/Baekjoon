package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_1233_사칙연산유효성검사 {
	static int N;
	static String[] tree;
	static String[] result;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1233_사칙연산유효성검사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine());
			int c = 0;
			for (int i = 0; i < N / 2 + 1; i++) {
				String[] data = br.readLine().split(" ");
				if (data[1].equals("+") || data[1].equals("-") || data[1].equals("*") || data[1].equals("/")) {
					c++;
				}
			}
			for(int i = N/2+1 ; i< N;i++) {
				br.readLine();
			}
			if(c == N/2) {
				System.out.println("#" + test_case + " " + 1);
			}else {
				System.out.println("#" + test_case + " " + 0);
			}
		}
	}
}