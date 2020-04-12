package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2231_분해합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int result = 0;
		int indexNums = N;
		while (indexNums / 10 != 0) {
			count++;
			indexNums /= 10;
		}

		indexNums = N;
		for (int i = 0; i < count; i++) {
			indexNums -= 9;
		}

		for (int i = indexNums; i < N; i++) {
			int temp = i;
			int r = temp;
			for (int j = 0; j < count; j++) {
				r += temp % 10;
				temp /= 10;
			}
			if(r == N) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
}
