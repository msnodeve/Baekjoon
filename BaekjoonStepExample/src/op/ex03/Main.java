package op.ex03;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int A, B;
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		A = 0 < A ? A : 0;
		B = scan.nextInt();
		B = 10 > B ? B : 0;
		System.out.println(A-B);
	}
}