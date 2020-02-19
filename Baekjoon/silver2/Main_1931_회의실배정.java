package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Conf{
	int start;
	int end;
	
	public Conf(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Conf [start=" + start + ", end=" + end + "]";
	}
}

class Main_1931_회의실배정 {
	static int N;
	static ArrayList<Conf> list;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1931_회의실 배정.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Conf(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Conf>() {
			@Override
			public int compare(Conf o1, Conf o2) {
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}else {
					return o1.end - o2.end;	
				}
				
			}
		});
	
		int result = 0;
		int last = -1;
		for(int i = 0 ; i<N; i++) {
			if(last <= list.get(i).start) {
				last = list.get(i).end;
				result++;
			}
		}
		
		System.out.println(result);
		
	}
}