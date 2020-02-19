package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1436_영화감독숌 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int findNum = 666;
		
		while(cnt != N) {
			if(Integer.toString(findNum).contains("666")) {
				cnt++;
			}
			findNum++;
		}
		
		System.out.println(findNum-1);
	}
}
