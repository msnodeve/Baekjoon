package swea.d2;

import java.util.Scanner;

class Solution_1926_간단한369게임 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int cnt = 0;
			String num = Integer.toString(i);
			String[] nums = num.split("");
			for (int j = 0; j < nums.length; j++) {
				if(nums[j].contains("3") || nums[j].contains("6") || nums[j].contains("9")){
					cnt++;
				}
			}
			
			if(cnt != 0) {
				for (int j = 0; j < cnt; j++) {
					System.out.print("-");					
				}
				System.out.print(" ");
			}
			else
				System.out.print(i + " ");
		}
	}
}