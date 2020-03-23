package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

    static int[][] map;
    static int[] pick, nonPick, arr;
    static int N, R, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            R = N / 2;
            pick = new int[R];
            nonPick = new int[R];
            arr = new int[N];
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                arr[i] = i+1;
            }
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 처리
            combination(0,0);
            
            // 출력
            System.out.println("#" + testcase + " " + result);
        }
    }

    private static void combination(int start, int cnt) {
        if (cnt == R) {
            int index = 0;
            for (int num : arr) {
                int c = 0;
                for (int p : pick) {
                    if (p == num)
                        c++;
                }
                if (c == 0)
                    nonPick[index++] = num;
            }

            int A = getSi(pick);
            int B = getSi(nonPick);
            result = Math.min(result, Math.abs(A-B));
            return;
        }
        for (int i = start; i < N; i++) {
            pick[cnt] = arr[i];
            combination(i + 1, cnt + 1);
        }
    }

    private static int getSi(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                result += map[arr[i]-1][arr[j]-1] + map[arr[j]-1][arr[i]-1];
            }
        }
        return result;
    }
}
