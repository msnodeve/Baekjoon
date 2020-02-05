package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws Exception {
		// File로 부터 읽을 것이다
		// System.in은 명령창으로 부터 테이터를 읽지만 setIn() 함수를 통해 입력 대상을 변경할 수 있다.
		System.setIn(new FileInputStream("res/swea/d3/1289_원재의메모리복구하기.txt"));
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = 0; // 메모리 복구 횟수
			String data = scan.next();
			int size = data.length();
			
			// startWith(str) : 문자열이 지정한 문자열로 시작하면 true, 아니면 false
			if(data.startsWith("1")) {
				cnt++;
			}
			
			for (int i = 0; i < size-1; i++) {
				// 현재 bit와 다음 bit가 같지 않으면 해당 bit로 복구
				if(data.charAt(i) != data.charAt(i+1)) {
					cnt++;
				}
			}
			System.out.println(String.format("#%d %d", test_case, cnt));
		}
	}
}
