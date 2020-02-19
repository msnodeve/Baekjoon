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
		
		// 현재 소를 볼수 있는 소들만 담아 놓기
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int value = scan.nextInt();
			// 현재 소를 볼 수 없는(작거나 같은 키의 소) 모두 뺌
			while(!stack.isEmpty()  && stack.peek() <= value) {
				stack.pop();
			}
			// 남아 있는 소는 모두 현재 소를 볼 수 있는 소들
			cnt += stack.size();
			stack.push(value);
		}
		
		
		
		System.out.println(cnt);
	}
}
