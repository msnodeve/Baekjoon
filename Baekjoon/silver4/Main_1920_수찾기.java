package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_1920_수찾기 {
	static int N, M;
	static int[] listN, listM;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/baekjoon/1920_수 찾기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        listN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
			listN[i] = Integer.parseInt(st.nextToken());
		}
        M = Integer.parseInt(br.readLine());
        listM = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
			listM[i] = Integer.parseInt(st.nextToken());
		}
        
        // 처리 및 출력
        Arrays.sort(listN);
        for (int i = 0; i < M; i++) {
        	if(Arrays.binarySearch(listN, listM[i]) >= 0) {
        		System.out.println(1);
        	}else {
        		System.out.println(0);
        	}
		}
        
    }

}
