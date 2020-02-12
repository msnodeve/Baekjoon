package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_11399_ATM {
	static int[] person;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/11399_ATM.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		person = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(person);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				result += person[j];
			}
		}
		
		System.out.println(result);
	}
}
