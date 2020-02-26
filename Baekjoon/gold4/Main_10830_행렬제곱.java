package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10830_행렬제곱 {
    static int N;
    static long B;
    static long[][] A, C;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new long[N][N];
        C = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                A[i][j] %= 1000;
            }
        }

        //처리
        C = divideConquer(A, B);

        // 출력
        for (long[] row : C) {
            for(long col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static long[][] divideConquer(long[][] a, long b) {
        if (b == 0) {
            return new long[][]{{1, 1}, {1, 1}};
        }
        if (b == 1) {
            return a;
        }
        long[][] result = divideConquer(a, b >> 1);
        if (b % 2 == 0) {
            return power(result, result);
        } else {
            return power(power(result, result), a);
        }
    }

    private static long[][] power(long[][] a, long[][] b) {
        long[][] temp = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += a[i][k] * b[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }
        return temp;
    }
}
