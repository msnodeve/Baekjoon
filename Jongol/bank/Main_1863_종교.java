package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int[] parent;
	static int N, M;
	static int result;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/jungol/1863_종교.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			unionSet(c, p);
		}
		
		for (int i = 1; i < N+1; i++) {
			if(i == parent[i]) {
				result++;
			}
		}
		
		System.out.println(result);
	}

	public static void makeSet(int v) {
		parent[v] = v;
	}
	
	public static int findSet(int v) {
		if(parent[v] == v) {
			return v;
		}
		parent[v] = findSet(parent[v]);
		return parent[v];
	}
	
	public static void unionSet(int u, int v) {
		parent[findSet(u)] = findSet(v);
	}
}
