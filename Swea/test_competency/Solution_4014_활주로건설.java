package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
    static int N, X, result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            result = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            // 처리
            for (int i = 0; i < N; i++) // 가로 탐색
                if (check(map[i]))
                    result++;
            for (int i = 0; i < N; i++) { // 세로 탐색
                int[] temp = new int[N];
                for (int j = 0; j < N; j++)
                    temp[j] = map[j][i];
                if (check(temp))
                    result++;
            }

            // 출력
            System.out.println("#" + testcase + " " + result);
        }
    }

    static boolean check(int[] road) {
        int count = 1;
        int height = road[0];

        for (int i = 1; i < N; i++) {
            if (height == road[i]) // 활주로의 높이가 같다면
                count++;
            else if (height - road[i] == 1) { // 활주로의 높이가 기준 보다 1 작다면
                if (N < X + i) // X길이 + 지금까지의 거리가 N보다 크다면 범위 밖
                    return false;
                for (int j = 1; j < X; j++)  // 다음 위치까지 한번 탐색
                    if (height - road[++i] != 1)
                        return false;
                height = road[i]; // 그 위치를 기준 높이로
                count = 0;
            } else if (road[i] - height == 1) { // 활주로의 높이가 기준 보다 1 크다면
                if (count < X) // X길이 보다 이전값이 작다면 범위 밖
                    return false;
                else {
                    height = road[i];
                    count = 1;
                }
            } else
                return false;
        }
        return true;
    }
}
