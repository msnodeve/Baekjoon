package jungol.data_processing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1146_선택정렬 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1146_선택정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		// 처리 및 출력
		for (int i = 0; i < N-1; i++) {
			int index = i;
			for (int j = i+1; j < N; j++) {
				if(list[index] > list[j]) {
					index = j;
				}
			}
			int temp = list[index];
			list[index] = list[i];
			list[i] = temp;
			
			for(int l : list)
				System.out.print(l + " ");
			System.out.println();
		}
	}
}
