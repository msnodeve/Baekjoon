package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_2007_패턴마디의길이 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d2/2007_패턴 마디의 길이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			String line = br.readLine();
			
			int result = 0;
			
			for (int i = 1; i < 10; i++) {
				if(line.substring(0, i).equals(line.substring(i, i+i))) {
					result = i;
					break;				
				}
			}
			System.out.println("#"+test_case + " " + result);
		}		
	}
}