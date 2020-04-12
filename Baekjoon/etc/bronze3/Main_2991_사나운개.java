package baekjoon.bronze3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2991_사나운개 {
	
	public static int attack(int m, int A, int B) {
		m = m % (A + B);
		if(m == 0)
			return 0;
		else if(0 < m && m <= A)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/2991_사나운 개.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A, B, C, D;
		int P, M, N;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		P = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	
		System.out.println(attack(P, A, B) + attack(P, C, D));
		System.out.println(attack(M, A, B) + attack(M, C, D));
		System.out.println(attack(N, A, B) + attack(N, C, D));
	}
}
