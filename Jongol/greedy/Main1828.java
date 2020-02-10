package jungol.greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1828 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/greedy/1828_냉장고.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		int[][] cs = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cs[i][0] = Integer.parseInt(st.nextToken());
			cs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int last = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(last < cs[i][0]) {
				last = cs[i][1];
				result++;
			}
		}
		
		System.out.println(result);
	}
}
