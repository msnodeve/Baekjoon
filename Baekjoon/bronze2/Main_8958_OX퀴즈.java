package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_8958_OX퀴즈 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/8958_OX 퀴즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1; testcase <= T; testcase++) {
			String[] inputs = br.readLine().split("");
			int cnt = 0;
			int addCount = 1;
			for (int i = 0; i < inputs.length; i++) {
				if(inputs[i].equals("O")) {
					cnt += addCount;
					addCount++;
				}else {
					addCount = 1;
				}
			}
			System.out.println(cnt);
		}
	}
}
