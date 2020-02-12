package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

class Solution_3456_직사각형길이찾기 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/3456_직사각형 길이 찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int T = Integer.parseInt(br.readLine());

		// 처리
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < 3; i++) {
				int n = Integer.parseInt(st.nextToken());
				if (!map.containsKey(n)) {
					map.put(n, 1);
				} else {
					int temp = map.get(n);
					map.put(n, ++temp);
				}
			}
			
			// 출력
			Set<Integer> keys = map.keySet();
			for (int key : keys) {
				if (map.get(key) % 2 == 1) {
					System.out.println("#" + testcase + " " + key);
				}
			}

		}
	}
}