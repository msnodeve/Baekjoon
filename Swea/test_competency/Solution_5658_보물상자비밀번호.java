package swea;

import javax.management.StandardEmitterMBean;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5658_보물상자비밀번호 {
    static PriorityQueue<Integer> result;
    static char[] list;
    static int N, K, M;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            M = N / 4;
            list = new char[N + M];
            result = new PriorityQueue<>(Collections.reverseOrder());
            String[] line = br.readLine().split("");
            for (int i = 0; i < N; i++) {
                list[i] = line[i].charAt(0);
            }
            for (int i = 0; i < M; i++) {
                list[i + N] = list[i];
            }

            for (int k = 0; k < M; k++) {
                for (int i = 0; i < 4; i++) {
                    char[] tempList = new char[M];
                    int cnt = 0;
                    for (int j = k + i * M; j < k + M + i * M; j++) {
                        tempList[cnt++] = list[j];
                    }
                    sum(tempList);
                }
            }
            int r = 0;
            for (int i = 0; i < K; i++) {
                r = result.poll();
            }
            System.out.println("#" + testcase + " " + r);
        }
    }

    private static void sum(char[] l) {
        int sum = Integer.parseInt(String.valueOf(l), 16);
        if(!result.contains(sum))
            result.offer(sum);
    }
}
