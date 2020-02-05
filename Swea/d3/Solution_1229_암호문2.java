package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution_1229_암호문2 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/1229_암호문2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		LinkedList<String> list = new LinkedList<>();
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 입력
			int N = Integer.parseInt(br.readLine());
			String[] st = br.readLine().split(" ");
			list.addAll(Arrays.asList(st));
			int cdN = Integer.parseInt(br.readLine());
			StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < cdN; i++) {
				if(stz.nextToken().equals("I")) {
					int index = Integer.parseInt(stz.nextToken());
					int cnt = Integer.parseInt(stz.nextToken());
					for (int j = 0; j < cnt; j++) {
						list.add(index++, stz.nextToken());
					}
				}else {
					int index = Integer.parseInt(stz.nextToken());
					int cnt = Integer.parseInt(stz.nextToken());
					for (int j = 0; j < cnt; j++) {
						list.remove(index);
					}
				}
			}
			
			System.out.print("#"+test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			list.clear();
		}
	}
}