package step_for.ex02;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		N = N <= 100000 ? N : 1;
		for (int i = N; i >= 1; i--) {
			System.out.println(i);
		}
	}
}
