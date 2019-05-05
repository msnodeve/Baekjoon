package op.ex04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
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