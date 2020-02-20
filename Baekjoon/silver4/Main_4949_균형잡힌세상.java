package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

class Main_4949_균형잡힌세상 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/4949_균형잡힌 세상.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {			
			// 입력
			String line = br.readLine();
			
			// 종료 조건
			if(line.charAt(0) == '.')
				break;
			
			// 처리
			boolean flag = false;
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < line.length(); i++) {
				char l = line.charAt(i);
				switch(l) {
				case '(':
					stack.push('(');
					break;
				case ')':
					if(!stack.isEmpty()) {
						l = stack.peek();
						if(l == '(') {
							stack.pop();	
						}else {
							flag = true;
						}
					}else {
						flag = true;
					}						
					break;
				case '[':
					stack.push('[');
					break;
				case ']':
					if(!stack.isEmpty()) {
						l = stack.peek();
						if(l == '[') {
							stack.pop();	
						}else {
							flag = true;
						}
					}else {
						flag = true;
					}	
					break;
				case '.':
					if(!stack.isEmpty()) {
						flag = true;
					}
					break;
				}
			}
			if(flag)
				System.out.println("no");
			else
				System.out.println("yes");
			
		}
		// 출력
		
	}

}
