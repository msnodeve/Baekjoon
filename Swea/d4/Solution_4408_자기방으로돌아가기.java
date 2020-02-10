package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_4408_자기방으로돌아가기 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/4408_자기 방으로 돌아가기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int rooms[] = new int[401];
			int max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int currRoom = Integer.parseInt(st.nextToken());
				int backRoom = Integer.parseInt(st.nextToken());

				if (currRoom > backRoom) {
					int temp = currRoom;
					currRoom = backRoom;
					backRoom = temp;
				}

				for (int j = currRoom; j <= backRoom; j++) {
					rooms[j]++;
				}
				for (int j = 1; j < rooms.length; j++) {
					max = Math.max(max, rooms[j]);
				}
			}
			System.out.println("#" + testcase + " " + max);
		}
	}
}