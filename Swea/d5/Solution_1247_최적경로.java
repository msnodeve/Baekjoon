package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좌표를 담을 공간
class Location {
	int x;
	int y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
}

class Solution_1247_최적경로 {
	static int[] permutation; // 순열을 담을 배열
	static boolean[] selected; // 중복된 순열을 제거
	static int result;
	static int N;
	static Location[] location; // 고객들
	static Location company, home; // 회사 및 집

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/1247_최적 경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			permutation = new int[N];
			selected = new boolean[N + 1];
			location = new Location[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				location[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// 처리
			permutation(0);
			
			// 출력
			System.out.println("#" + testcase + " " + result);
		}
	}

	public static void permutation(int cnt) {
		if (cnt == N) {
			// 뽑아낸 고객의 중복되지 않은 순열의 수
			// 뽑아낸 순열로 시작
			calculation(permutation);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				permutation[cnt] = i;
				selected[i] = true;
				permutation(cnt + 1);
				selected[i] = false;
			}
		}
	}

	public static void calculation(int[] perm) {
		// 회사와 첫번째 고객 사이의 거리
		int sum = Math.abs(company.x - location[perm[0]].x) + Math.abs(company.y - location[perm[0]].y);

		// 첫번째 고객과 마지막 고객까지의 거리 합
		for (int i = 0, size = perm.length; i < size - 1; i++) {
			sum += Math.abs(location[perm[i + 1]].x - location[perm[i]].x)
					+ Math.abs(location[perm[i + 1]].y - location[perm[i]].y);
		
			// 만약 지금까지의 합이 더 크다면 더 이상 볼 겨를도 주지말기
			if(sum > result) {
				return;
			}
		}
		
		// 집과 마지막 고객 사이의 거리
		sum += Math.abs(location[perm[N - 1]].x - home.x) + Math.abs(location[perm[N - 1]].y - home.y);

		// 최소값 저장 
		result = Math.min(result, sum);
	}
}