package io.ex07;

import java.io.IOException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		String str = "";
		while(scan.hasNextLine()) {
			str = scan.nextLine();
			System.out.println(str);
		}
	}
}
