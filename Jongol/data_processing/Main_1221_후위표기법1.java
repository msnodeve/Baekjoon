package jungol.data_processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1221_후위표기법1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1221_후위표기법1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			String s = st.nextToken();
			if("0123456789".contains(s)) {
				stack.push(Integer.parseInt(s));
			}else if(s.charAt(0) == '+') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			}else if(s.charAt(0) == '-') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
			}else if(s.charAt(0) == '*') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			}else if(s.charAt(0) == '/') {
				int a = stack.pop();
				int b = stack.pop();
				if(a == 0) 
					return;
				else
					stack.push(b/a);
			}
		}
		System.out.println(stack.pop());
	}
}
