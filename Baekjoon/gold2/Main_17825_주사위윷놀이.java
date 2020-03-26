package gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이 {
    // 모든 칸에서 1~5가 나왔을때의 다음 도착 칸의 번호를 저장해둔 배열을 준비
    // 모든 칸에 대해 해당 칸의 점수를 저장해둔 배열을 준비
    static int[][] moveMap;
    // 4마리의 말이 각각 현재 어느 칸에 위치한지 저장할 배열을 준비
    static int[] pos;
    // 10개의 주사위가 갖고 있는 값을 각각 저장할 배열을 준비
    static int[] dice;
    static int result;
    // 중복순열의 경우의 수를 구하는 재귀함수

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        init();
        pos = new int[4];
        dice = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int idx, int score) {
        if (idx == 10) {
            result = Math.max(result, score);
            return;
        }
        out:
        for (int i = 0; i < 4; i++) {
            // 종료된말은 이동못함
            if (pos[i] == -1)
                continue;
            int now = pos[i];
            int next = moveMap[now][dice[idx]];
            // 끝나는 이동
            if (next == 0) {
                pos[i] = -1;
                dfs(idx + 1, score);
                pos[i] = now;
            }
            // 다른 말과 겹치게 되면 이동 불가
            for (int j = 0; j < 4; j++) {
                if (i == j)
                    continue;
                if (pos[j] == next)
                    continue out;
            }
            pos[i] = next;
            dfs(idx + 1, score + moveMap[next][0]);
            pos[i] = now;
        }
    }

    static void init() {
        moveMap = new int[32][6];
        pos = new int[4];
        moveMap[0] = new int[]{0, 1, 2, 3, 4, 5};
        moveMap[1] = new int[]{2, 2, 3, 4, 5, 6};
        moveMap[2] = new int[]{4, 3, 4, 5, 6, 7};
        moveMap[3] = new int[]{6, 4, 5, 6, 7, 8};
        moveMap[4] = new int[]{8, 5, 6, 7, 8, 9};
        moveMap[5] = new int[]{10, 21, 22, 23, 24, 25};
        moveMap[6] = new int[]{12, 7, 8, 9, 10, 11};
        moveMap[7] = new int[]{14, 8, 9, 10, 11, 12};
        moveMap[8] = new int[]{16, 9, 10, 11, 12, 13};
        moveMap[9] = new int[]{18, 10, 11, 12, 13, 14};
        moveMap[10] = new int[]{20, 27, 28, 24, 25, 26};
        moveMap[11] = new int[]{22, 12, 13, 14, 15, 16};
        moveMap[12] = new int[]{24, 13, 14, 15, 16, 17};
        moveMap[13] = new int[]{26, 14, 15, 16, 17, 18};
        moveMap[14] = new int[]{28, 15, 16, 17, 18, 19};
        moveMap[15] = new int[]{30, 29, 30, 31, 24, 25};
        moveMap[16] = new int[]{32, 17, 18, 19, 20, 0};
        moveMap[17] = new int[]{34, 18, 19, 20, 0, 0};
        moveMap[18] = new int[]{36, 19, 20, 0, 0, 0};
        moveMap[19] = new int[]{38, 20, 0, 0, 0, 0};
        moveMap[20] = new int[]{40, 0, 0, 0, 0, 0};
        moveMap[21] = new int[]{13, 22, 23, 24, 25, 26};
        moveMap[22] = new int[]{16, 23, 24, 25, 26, 20};
        moveMap[23] = new int[]{19, 24, 25, 26, 20, 0};
        moveMap[24] = new int[]{25, 25, 26, 20, 0, 0};
        moveMap[25] = new int[]{30, 26, 20, 0, 0, 0};
        moveMap[26] = new int[]{35, 20, 0, 0, 0, 0};
        moveMap[27] = new int[]{22, 28, 24, 25, 26, 20};
        moveMap[28] = new int[]{24, 24, 25, 26, 20, 0};
        moveMap[29] = new int[]{28, 30, 31, 24, 25, 26};
        moveMap[30] = new int[]{27, 31, 24, 25, 26, 20};
        moveMap[31] = new int[]{26, 24, 25, 26, 20, 0};
    }
}
