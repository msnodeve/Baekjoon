package jungol.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main_1809_탑_김명석 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/t.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] top = new int[T];
		int[] result = new int[T];
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		for (int i = 0; i < T; i++) {
			top[i] = scan.nextInt();
			while (!stack.isEmpty() && stack.peek() < top[i]) {
				stack.pop();
				index.pop();
			}
			if (!stack.isEmpty() && stack.peek() > top[i]) {
				result[i] = index.peek();
			}
			stack.push(top[i]);
			index.push(i+1);
		}
		for(int r : result) {
			System.out.print(r + " ");
		}
	}
}
