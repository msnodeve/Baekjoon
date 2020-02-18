package baekjoon.bronze5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2575{
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 5; i++) {
			result += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		
		System.out.println(result % 10);
	}
}