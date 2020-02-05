package step_for.ex11;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word;
		word = scan.nextLine();
		for (int i = 0; i < word.length(); i++) {
			if (i % 10 == 0 && i != 0) {
				System.out.println();
			}
			System.out.print(word.charAt(i));
		}
	}
}
