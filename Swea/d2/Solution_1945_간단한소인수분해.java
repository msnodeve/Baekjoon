package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_1945_간단한소인수분해 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d2/1945_간단한 소인수분해.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] l = {2, 3, 5, 7, 11};
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			int index = 0;
			int[] result = new int[5];
			int N = Integer.parseInt(br.readLine());
			
			// 처리
			while(true) {
				if(N%l[index] == 0) {
					N /= l[index];
					result[index]++;
				}else {
					index++;
					if(index == 5)
						break;
				}
			}
			
			System.out.print("#"+test_case + " ");
			for(int i : result)
				System.out.print(i+ " ");
			System.out.println();
		}		
	}
}