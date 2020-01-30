package jungol.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main_1141_불쾌한날_김명석 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/jungol/bank/1141_불쾌한날.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long cnt = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int value = scan.nextInt();
			while(!stack.isEmpty()  && stack.peek() <= value) {
				stack.pop();
			}
			cnt += stack.size();
			stack.push(value);
		}
		
		
		
		System.out.println(cnt);
	}
}
