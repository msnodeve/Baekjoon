package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main_2108_통계학 {
	static int N;
	static int[] listN;
	static int[] listNn; // 최빈값 구하는 리스트
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int middle, sum;
	static double avg;
	static int binMax;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 및 처리
		N = Integer.parseInt(br.readLine());
		listN = new int[N];
		listNn = new int[8001];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			listN[i] = num;
			listNn[4000+num]++;
		}
		avg = (double) sum / N;
		Arrays.sort(listN);
		ArrayList<Integer> l = new ArrayList<>();
		middle = listN[N/2];
		for (int i = 0; i<8001; i++) {
			if(listNn[binMax] < listNn[i]) {
				binMax = i;
				l.clear();
			}else if(listNn[i] != 0 && listNn[i] == listNn[binMax]) {
				l.add(i-4000);
			}
		}
		System.out.println(Math.round(avg));
		System.out.println(middle);
		if(l.size() != 0)
			System.out.println(l.get(0));
		else
			System.out.println(binMax-4000);
		System.out.println(listN[N-1] - listN[0]);
	}

}
