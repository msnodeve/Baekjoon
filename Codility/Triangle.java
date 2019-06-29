// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;
class Solution {
	public int solution(int[] A) {
		int N = A.length;
		if (3 > N) return 0;

		Arrays.sort(A);

		for (int i = 0; i < N - 2; i++) {
			long P = A[i], Q = A[i + 1], R = A[i + 2];
			if (P + Q > R) return 1;
		}
		return 0;
	}
}