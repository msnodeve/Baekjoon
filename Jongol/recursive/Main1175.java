package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Main1175 {
	static int N; // n개의 원소 수
	static int R; // 추출할 개수
	static int[] numbers; // 순열을 담을 배열
	static int testcase; // 순열의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 6;
		R = sc.nextInt();
		numbers = new int[R];
		permutation(0);
		System.out.printf("중복 순열 %dㅠ%d의 개수 : %d",N,R,testcase);
	}
	/**
	 * 순열을 만들 함수
	 * @param cnt 배열의 index 
	 */
	private static void permutation(int cnt) {
		if(cnt == R) { // cnt가 N이라는 것은 원소를 N 개 만큼 추출
			testcase++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}
}
