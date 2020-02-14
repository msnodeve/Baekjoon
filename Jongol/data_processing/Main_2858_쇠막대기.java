package jungol.data_processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2858_쇠막대기 {
	static int result;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/2858_쇠막대기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		String inputs = br.readLine();
		Stack<Character> stack = new Stack<>();
		// 처리
		for (int i = 0; i < inputs.length(); i++) {
			if(inputs.charAt(i) == '(') {
				stack.push('(');
			}else {
				stack.pop();
				if(inputs.charAt(i-1) == '(') {
					result += stack.size();
				}else {
					result++;
				}
			}
		}
		
		// 출력
		System.out.println(result);
	}
}
