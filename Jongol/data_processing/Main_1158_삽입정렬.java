package jungol.data_processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1158_삽입정렬 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1158_삽입정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		// 처리 및 출력
		for (int i = 1; i < N; i++) {
			// 기준
			int pibot = list[i];
			// 비교할 대상
			int test = i - 1;
			
			while(test > -1 && pibot < list[test]) {
				// 기준보다 비교대상이 큰 경우 오른쪽으로 밀어냄
				list[test +1] = list[test];
				test--;
			}
			
			// 비어있는 곳에 기준 값 저장
			list[test+1] = pibot;
			
		}
	}
}
