package gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2749_피보나치수3 {
    static long N; // 1000000000000000000보다 작거나 같은 자연수
    static final int MOD = 1000000; // 나눠야 할 수
    static long[][] origin, temp, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Long.parseLong(br.readLine()); // N 번째 수를 찾아라
        origin = new long[][]{{1, 1}, {1, 0}};

        //처리
        result = divideConquer(origin, N);

        // 출력
        System.out.println(result[0][1]);
    }

    private static long[][] divideConquer(long[][] list, long n) {
        if (n == 0) {
            return new long[][]{{1, 0}, {0, 1}};
        }
        if (n == 1) {
            return list;
        }
        long[][] res = divideConquer(list, n >> 1);
        if(n % 2 == 0){
            return power(res, res);
        }else{
            return power(power(res, res), list);
        }
    }

    private static long[][] power(long[][] list1, long[][] list2) {
        temp = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += list1[i][k] * list2[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }
        return temp;
    }
}
