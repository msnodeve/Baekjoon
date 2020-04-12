package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_3052_나머지 {
	static int[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new int[42];
		int T = 10;
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine()) % 42;
			
			list[num]++;
		}
		
		int result = 0;
		
		for (int i : list) {
			if(i != 0) {
				result++;
			}
		}
		System.out.println(result);
	}
}
