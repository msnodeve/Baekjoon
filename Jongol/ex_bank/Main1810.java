package com.ssafy.combination;

import java.util.Arrays;
import java.util.Scanner;

public class Main1810 {
	static int[] arr;
	static int n = 9;
	static int r = 7;
	static int[] combi;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 난장이 9명을 담을 배열 생성 및 초기화
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = scan.nextInt();
		}		
		
		// 조합을 담을 배열
		combi = new int[r];
		
		combination(0, 1);
		
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == r) {
			int sum = 0;
			for(int c : combi) {
				sum += arr[c-1];
			}
			if(sum == 100)
				for(int c : combi) {
					System.out.println(arr[c-1]);
				}
			return;
		}
		for (int i = start; i <= n; i++) {
			combi[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}
