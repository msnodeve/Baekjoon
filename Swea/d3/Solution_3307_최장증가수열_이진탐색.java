package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_최장증가수열_이진탐색 {

    static int N, number[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            number = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + testcase + " " + lis());
        }
    }

    private static int lis() {
        int[] lis = new int[N];
        int size = 0;
        for (int i = 0; i < N; i++) {
            int temp = -Arrays.binarySearch(lis, 0, size, number[i]) - 1;
            lis[temp] = number[i];
            if (temp == size)
                size++;
        }
        return size;
    }

    private static int lisPath() {
        int[] lis = new int[N];
        int[] pre = new int[N];
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            lis[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (number[j] < number[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    pre[i] = j;
                }
            }
            if (lis[maxIndex] < lis[i]) {
                maxIndex = i;
            }
        }
        return lis[maxIndex];
    }
}
