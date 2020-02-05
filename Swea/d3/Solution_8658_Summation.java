package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_8658_Summation {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = 10;
		
		for (int testcase = 1; testcase <= T; testcase++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int sum = 0;
				StringTokenizer s = new StringTokenizer(st.nextToken(), " ");
				String[] nums = s.nextToken().split("");
				for (int j = 0; j < nums.length; j++) {
					sum += Integer.parseInt(nums[j]);
				}
				min = sum < min ? sum: min;
				max = sum > max ? sum: max;
			}
			
			System.out.println("#" + testcase + " " + max + " " + min);
		}
	}
}