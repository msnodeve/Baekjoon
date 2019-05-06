package step_for.ex05;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		N = 1 <= N && N <= 100 ? N : 1;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j < N; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
