package jungol.create_shape1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1438 {
	static int[][] map = new int[102][102];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1438_색종이1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j = a; j < a+10; j++) {
				for (int k = b; k < b+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if(map[i][j] != 0) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
