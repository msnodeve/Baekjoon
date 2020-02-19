package jungol.greedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Library {
	int in;
	int out;

	public Library(int in, int out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public String toString() {
		return "Library [in=" + in + ", out=" + out + "]";
	}

}

class Main_2247_도서관 {
	static int N;
	static ArrayList<Library> list;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/jungol/2247_도서관.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Library(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new Comparator<Library>() {
			@Override
			public int compare(Library o1, Library o2) {
				if (o1.in == o2.in) {
					return o1.out - o2.out;
				}
				return o1.in - o2.in;
			}
		});

		int emptyTime = list.get(0).in;
		int fullTime = list.get(0).out - list.get(0).in;
		int tempIn = list.get(0).in;
		int tempOut = list.get(0).out;
		for (int i = 0; i < N; i++) {
			if(tempOut >= list.get(i).in) {
				tempOut = Math.max(tempOut, list.get(i).out);
				fullTime = Math.max(fullTime, tempOut - tempIn); 
			}else {
				tempIn = list.get(i).in;
				emptyTime = Math.max(emptyTime, tempIn - tempOut);
				tempOut = list.get(i).out;
			}
		}
		
		System.out.println(fullTime + " " + emptyTime);
	}
}