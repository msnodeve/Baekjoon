package step_for.ex08;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		N = 1 <= N && N <= 10000 ? N : 1;
		System.out.println((N*(N+1))/2);
	}
}
