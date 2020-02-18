package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2562_최댓값 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 9;
		int[] nums = new int[T];
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int testcase = 0; testcase < T; testcase++) {
			int num =Integer.parseInt(br.readLine());
			if(max < num) {
				index = testcase+1;
				max = num;
			}
		}
		
		System.out.println(max);
		System.out.println(index);
	}
}
