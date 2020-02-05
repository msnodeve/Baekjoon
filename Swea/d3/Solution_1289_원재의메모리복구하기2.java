package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1289_원재의메모리복구하기2 {
	public static void main(String[] args) throws Exception {
		// File로 부터 읽을 것이다
		// System.in은 명령창으로 부터 테이터를 읽지만 setIn() 함수를 통해 입력 대상을 변경할 수 있다.
		System.setIn(new FileInputStream("res/swea/d3/1289_원재의메모리복구하기.txt"));
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = 1; // 메모리 복구 횟수
			String data = scan.next();
			int size = data.length();
			StringBuilder nData = new StringBuilder(data); // 비트를 변경해서 원본과 같은지 비교할 대상
			// 첫 1의 위치를 찾기
			int idx = data.indexOf("1");
			for (int i = idx; i <= size;) {
				change(nData, i, size, "" + (cnt % 2));
				if (data.equals(nData.toString())) {
					break;
				}

				for (int j = i + 1; j < size; j++) {
					// 두 문자열을 비교 charAt(index) : 문자열의 index 위치에 해당하는 문자 하나를 리턴
					if (data.charAt(j) != nData.charAt(j)) {
						i = j;
						break;
					}
				}
				cnt++; // 다른 bit이므로 복구 카운트 증가
			}
			System.out.println(String.format("#%d %d", test_case, cnt));
		}
	}

	private static void change(StringBuilder nData, int start, int end, String fill) {
		for (int i = start; i < end; i++) {
			nData.replace(i, i + 1, fill);
		}
	}

}
