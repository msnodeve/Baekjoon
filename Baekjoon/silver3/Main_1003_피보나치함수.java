package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1003_피보나치함수 {
    static int N;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int zeroCount[] = new int[41];
        int oneCount[] = new int[41];
        // 입력
        int T = Integer.parseInt(br.readLine());
        zeroCount[0] = 1;
        zeroCount[1] = 0;
        oneCount[0] = 0;
        oneCount[1] = 1;
        for (int i = 2; i < 41; i++) {
            zeroCount[i] = zeroCount[i-1] + zeroCount[i-2];
            oneCount[i] = oneCount[i-1] + oneCount[i-2];
        }
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(zeroCount[N] + " " + oneCount[N]);
        }
    }
}
