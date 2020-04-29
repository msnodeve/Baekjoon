package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인 {
    static ArrayList<Integer> list;
    static int N, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            result = 0;
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                list.add(value);
                result += value;
            }

            Collections.sort(list);
            for (int i = list.size() - 3; i > -1; i = i - 3) {
                result -= list.get(i);
            }
            System.out.println("#" + testcase + " " + result);
        }
    }
}
