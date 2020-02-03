package jungol.create_shape1;

import java.util.Scanner;

public class Main1341 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputS = sc.nextInt(); // 구구단의 시작 범위
		int inputE = sc.nextInt(); // 구구단의 끝 범위
		while (2 > inputS || inputS > 9 || 2 > inputE || inputE > 9) {
			System.out.println("INPUT ERROR!");
			inputS = sc.nextInt();
			inputE = sc.nextInt();
		}
		// s가 큰 경우
		if (inputS > inputE)
			for (int j = inputS; j > inputE - 1; j--) {
				for (int i = 1; i < 10; i++) {
					System.out.printf(j + " * " + i + " = %2d   ", j * i);
					if (i % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}

		else
			for (int j = inputS; j < inputE + 1; j++) {
				for (int i = 1; i < 10; i++) {
					System.out.printf(j + " * " + i + " = %2d   ", j * i);
					if (i % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
			
	}
}
