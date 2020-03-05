package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1808_지희의고장난계산기 {
    static int X;
    static int min;
    static boolean[] btn;

    public static void main(String[] args) throws Exception {
        // 입력
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int testcase = 1; testcase <= T; testcase++) {
            // min값 초기화 Integer.MAX_VALUE
            min = Integer.MAX_VALUE;
            btn = new boolean[10];
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            // btn 1이면 true로 설정
            int num;
            for (int i = 0; i < 10; i++) {
                num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    btn[i] = true;
                }
            }
            X = Integer.parseInt(br.readLine().trim());


            // 처리 dfs => 재귀함수
            find(X, 0);


            // 출력
            // min == Integer.MAX_VALUE ? -1 : min
            min = min == Integer.MAX_VALUE ? -1 : min;
            System.out.println("#" + testcase + " " + min);
        }
    }

    private static int find(int x, int cnt) {
        //  base case => 종료 조건
        if (isMake(x + "")) {
            //      x값이 주어진 모든 숫자로 누를 수 있는지 검사
            //          return x의 길이
            if (cnt == 0) {
                min = len(x) + 1; // 계산 버튼을 위해 1을 더함
            }
            return len(x) + 1;
        }
        //  처리
        //      result 값을 -1로 초기화
        int result = -1;
        //          2 ~ 제곱근 까지 반복
        for (int i = 2, end = (int) Math.sqrt(x) + 1; i < end; i++) {
            // i 는 x의 약수, 모든 수로 누를 수 있는지 검사
            if (x % i == 0 && isMake(i + "")) {
                //                  i의 길이를 구하고
                int len1 = len(i) + 1; // 곱하기 버튼을 위해 1을 더함
                //                  몫이 x의 약수, 모든 수로 누를 수 있는지 검사 ==> 재귀
                int len2 = find(x / i, cnt + 1);
                //              몫이 -1이 아니면 => x의 약수, 모든 수로 누를 수 있다
                if (len2 > -1) {
                    //                  i의 길이 + 몫의 길이 + * =
                    result = len1 + len2;
                    if (result < min && x == X) {
                        //                  결과가 min 비교후 갱신
                        min = result;
                    }
                }
            }
        }
        return result;
    }

    private static int len(int x) {
        return (int) Math.log10(x) + 1;
    }

    private static boolean isMake(String x) {
        for (char c : x.toCharArray()) {
            if (!btn[c - '0']) {
                return false;
            }
        }
        return true;
    }
}
