package step_for.ex01;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		N = N <= 100000 ? N : 1;
		for (int i = 1; i<=N; i++) {
			System.out.println(i);
		}
	}
}
