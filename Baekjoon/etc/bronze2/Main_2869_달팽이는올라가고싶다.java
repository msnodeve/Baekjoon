package baekjoon.bronze2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int count = 1;
		V = V - A;
		if (V - (A - B) * (V / (A - B)) > 0) {
			count += (V / (A - B)) + 1;
		}else {
			count += (V / (A - B));
		}

			System.out.println(count);
	}
}
