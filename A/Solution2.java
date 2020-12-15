package samsung01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {
	static class AP{
		int row, col;
		public AP(int row, int col) {
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "[r=" + row + ", c=" + col + "]";
		}
	}
	static class Item{
		int row, col, dist;
		boolean check;
		public Item(int row, int col, int dist, boolean check) {
			this.row = row;
			this.col = col;
			this.dist = dist;
			this.check = check;
		}
		@Override
		public String toString() {
			return "[r=" + row + ", c=" + col + ", d=" + dist + ", c=" + (check ? 1 : 0) + "]";
		}
	}
	static int N, apDist, result;
	static ArrayList<AP> aps;
	static ArrayList<Item> items;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\samsung01\\sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			apDist = Integer.parseInt(st.nextToken());
			aps = new ArrayList<>();
			items = new ArrayList<>(); 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num == 9) {
						aps.add(new AP(i, j));
					}else if(num != 0) {
						items.add(new Item(i, j, num, false));
					}
				}
			}
			for (int i = 1; i <= aps.size(); i++) {
				nums = new int[i];
				combination(0, 0, i);
			}
			System.out.println(result == Integer.MAX_VALUE ? "#" + t + " " + -1 : "#" + t + " " + result);
		}
		
	}
	private static boolean check() {
		for (Item item: items) {
			if(!item.check) {
				return false;
			}
			item.check = false;
		}
		return true;
	}
	private static void combination(int start, int cnt, int dest) {
		if(cnt == dest) {
			solve(nums);
			if(check()) {
				result = Math.min(result, dest);
			}
			return;
		}
		for (int i = start; i < aps.size(); i++) {
			nums[cnt] = i;
			combination(i+1, cnt+1, dest);
		}
	}
	private static void solve(int[] nums) {
		for (Item item : items) {
			int D = 0;
			for (int i = 0; i < nums.length; i++) {
				AP ap = aps.get(nums[i]);
				D = Math.abs(item.row - ap.row) + Math.abs(item.col - ap.col);
				if(D <= item.dist + apDist) {
					item.check = true;
				}
			}
		}
	}
}