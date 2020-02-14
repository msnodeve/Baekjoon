package jungol.data_processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1697_큐 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1697_큐.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken().charAt(0)) {
			case 'i':
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case 'o':
				if(queue.isEmpty()) {
					System.out.println("empty");
				}else {
					System.out.println(queue.poll());
				}
				break;
			case 'c':
				System.out.println(queue.size());
				break;
			}
		}
		
	}

}
