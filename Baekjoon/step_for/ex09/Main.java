package step_for.ex09;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		String num;
		int N = scan.nextInt();
		N = 1 <= N && N <= 100 ? N : 1;
		scan.nextLine();
		num = scan.nextLine();
		for (int i = 0; i < N; i++) {
			cnt += Integer.parseInt(num.substring(i, i + 1));
		}
		System.out.println(cnt);
	}
}
