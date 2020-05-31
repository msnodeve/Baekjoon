package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
    static int N, X, result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 확인
        /*for(int[] row : map)
            System.out.println(Arrays.toString(row));*/

        // 처리
        solution();

        // 출력
        System.out.println(result);
    }

    private static void solution() {
        // 가로라인 검사
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            boolean[] visit = new boolean[N];

            for (int j = 1; j < N; j++) {
                if (map[i][j - 1] == map[i][j])
                    continue; // 평평 하다면 다음 검사
                else if (map[i][j - 1] + 1 == map[i][j] && j >= X && !visit[j - X]) { // 오르막길 검사
                    // 길이 X인 경사로를 놓기위해 j가 그만큼 갔는지, 이미설치 되어있지 않는지 검사
                    for (int k = j - X; k < j; k++) {
                        if (map[i][j - 1] != map[i][k])
                            flag = false;
                        visit[k] = true;
                    }
                } else if (map[i][j - 1] - 1 == map[i][j] && j + X <= N) { // 내리막길 검사
                    // 길이 X인 경사로를 놓아봤을때, N보다 작은지
                    for (int k = j; k < j + X; k++) {
                        if (map[i][j] != map[i][k])
                            flag = false;
                        visit[k] = true;
                    }
                } else { // 그냥 이 라인은 아무것도 못하는 라인
                    flag = false;
                    break;
                }
            }

            if (flag)
                result++;
        }

        // 세로라인 검사
        for (int j = 0; j < N; j++) {
            boolean flag = true;
            boolean[] visit = new boolean[N];

            for (int i = 1; i < N; i++) {
                if (map[i - 1][j] == map[i][j])
                    continue;// 평평 하다면 다음 검사
                else if (map[i - 1][j] + 1 == map[i][j] && i >= X && !visit[i - X]) { // 오르막길 검사
                    for (int k = i - X; k < i; k++) {
                        if (map[k][j] != map[i - 1][j])
                            flag = false;
                        visit[k] = true;
                    }
                } else if (map[i - 1][j] - 1 == map[i][j] && i + X <= N) { // 내리막길 검사
                    for (int k = i; k < i + X; k++) {
                        if (map[k][j] != map[i][j])
                            flag = false;
                        visit[k] = true;
                    }
                } else { // 그냥 이 라인은 아무것도 못하는 라인
                    flag = false;
                    break;
                }
            }

            if (flag)
                result++;
        }
    }
}
