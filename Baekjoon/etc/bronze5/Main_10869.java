package baekjoon.bronze5;

import java.util.Scanner;

public class Main_10869 {
	public static void main(String[] args) throws Exception {
		int A, B;
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		A = 1 <= A ? A : 0;
		B = scan.nextInt();
		B = 10000 >= B ? B : 0;
		System.out.println(A+B);
		System.out.println(A-B);
		System.out.println(A*B);
		System.out.println(A/B);
		System.out.println(A%B);
	}
}