package baekjoon.bronze3;

import java.util.Scanner;

class Main_4153 {
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			if(a == 0 && b == 0)
				break;
			System.out.println(a + b);
		}
	}
}
