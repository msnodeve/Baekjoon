package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


class Word{
	public String word;
	public int len;
	
	public Word(String word, int len) {
		this.word = word;
		this.len = len;
	}	
}
public class Main_1181_단어정렬 {
	static Map<String, Integer> map;
	static ArrayList<Word> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1181_단어 정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		map = new HashMap<String, Integer>();
		list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, str.length());
		}

		for(String key : map.keySet()) {
			list.add(new Word(key, map.get(key)));
		}

		Collections.sort(list, new Comparator<Word>() {
			@Override
			public int compare(Word o1, Word o2) {
				int gap = o1.len - o2.len;
				if(gap == 0) {
					for (int i = 0; i < o1.len; i++) {
						if(o1.word.charAt(i) != o2.word.charAt(i)) {
							gap = o1.word.charAt(i) - o2.word.charAt(i);
							break;
						}
					}
				}
				return gap;
			}
		});
		
		for(Word w : list) {
			System.out.println(w.word);
		}
	}
}
