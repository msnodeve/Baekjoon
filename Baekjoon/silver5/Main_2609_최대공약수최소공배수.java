package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수최소공배수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		if (A < B) {
			int temp = A;
			A = B;
			B = temp;
		}

		int l = A, g = B;
		
		int r = 1;

		while (r > 0) {
			r = A % B;
			A = B;
			B = r;
		}
		
		System.out.println(A);
		System.out.println(l * g / A);
		
	}
}
