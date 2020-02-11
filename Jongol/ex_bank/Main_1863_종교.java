package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static HashMap<Integer, ArrayList<Integer>> map;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/bank/1863_종교.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (map.isEmpty()) {
				arr = new ArrayList<>();
				arr.add(b);
				map.put(a, arr);
			} else {
				if (map.containsKey(a)) {
					arr = map.get(a);
					arr.add(b);
					map.put(a, arr);
				} else {
					boolean flag = false;
					Set<Integer> keys = map.keySet();
					for (int key : keys) {
						arr = map.get(key);
						for (int j = 0; j < arr.size(); j++) {
							if (arr.get(j) == b) {
								arr.add(b);
								flag = true;
								map.put(key, arr);
								break;
							}
						}
						if (flag) {
							break;
						}							
					}
					if(!flag) {
						arr = new ArrayList<>();
						arr.add(b);
						map.put(a, arr);
					}
				}
			}
		}
		System.out.println(map.size());
	}

}
