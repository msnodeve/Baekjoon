package baekjoon.bronze5;

import java.util.Scanner;

public class Main_10430 {
	public static void main(String[] args) throws Exception {
		int A, B, C;
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		A = 2 <= A ? A : 0;
		B = scan.nextInt();
		C = scan.nextInt();
		C = 10000 >= C ? C : 0;
		System.out.println((A + B) % C);
		System.out.println((A % C + B % C) % C);
		System.out.println((A * B) % C);
		System.out.println((A % C * B % C) % C);
	}
}