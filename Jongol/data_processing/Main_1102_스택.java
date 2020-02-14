package jungol.data_processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1102_스택 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1102_스택.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken().charAt(0)) {
			case 'i':
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case 'o':
				if(stack.isEmpty()) {
					System.out.println("empty");
				}else {
					System.out.println(stack.pop());
				}
				break;
			case 'c':
				System.out.println(stack.size());
				break;
			}
		}
		
	}

}
