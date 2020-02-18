package baekjoon.bronze3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_10818 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			int num = Integer.parseInt(st.nextToken());
			if (min > num) {
				min = num;
			}
			
			if(max < num) {
				max = num;
			}
		}
		System.out.println(min + " " + max);
	}
}
