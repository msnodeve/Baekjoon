package baekjoon.bronze4;

import java.util.Scanner;
public class Main_1008 {
	public static void main(String[] args) {
		double A, B;
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		A = 0 < A ? A : 0;
		B = scan.nextInt();
		B = 10 > B ? B : 0;
		System.out.println(A/B);
	}
}
