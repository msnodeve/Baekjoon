package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
    static int[][] topni, directionOfK;
    static int[] checkDirection;
    static int K;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            K = Integer.parseInt(br.readLine());
            topni = new int[4][8];
            directionOfK = new int[K][2];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    topni[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                directionOfK[i][0] = Integer.parseInt(st.nextToken());
                directionOfK[i][1] = Integer.parseInt(st.nextToken());
            }

            // 처리
            for (int i = 0; i < K; i++) {
                checkDirection = new int[4];
                checkDirection[directionOfK[i][0] - 1] = directionOfK[i][1];
                checkDirection(directionOfK[i][0] - 1, i);
                for (int j = 0; j < 4; j++) {
                    if (checkDirection[j] == 1) {
                        go(j);
                    } else if (checkDirection[j] == -1) {
                        back(j);
                    }
                }
            }
            int result = 0;
            int bit = 1;
            for (int i = 0; i < 4; i++) {
                if (topni[i][0] == 1) {
                    result += bit;
                }
                bit *= 2;
            }
            // 출력
            System.out.println("#" + testcase + " " + result);
        }
    }

    private static void back(int j) {
        int temp = topni[j][0];
        for (int i = 1; i < 8; i++) {
            topni[j][i - 1] = topni[j][i];
        }
        topni[j][7] = temp;
    }

    private static void go(int j) {
        int temp = topni[j][7];
        for (int i = 7; i > 0; i--) {
            topni[j][i] = topni[j][i - 1];
        }
        topni[j][0] = temp;
    }

    private static void checkDirection(int dir, int d) {
        int cnt = 0;
        for (int i = dir; i > 0; i--) {
            if (topni[i - 1][2] == topni[i][6]) {
                break;
            } else {
                if (cnt % 2 == 0) {
                    checkDirection[i - 1] = -directionOfK[d][1];
                } else {
                    checkDirection[i - 1] = directionOfK[d][1];
                }
                cnt++;
            }
        }

        cnt = 0;
        for (int i = dir + 1; i < 4; i++) {
            if (topni[i][6] == topni[i - 1][2]) {
                break;
            } else {
                if (cnt % 2 == 0) {
                    checkDirection[i] = -directionOfK[d][1];
                } else {
                    checkDirection[i] = directionOfK[d][1];
                }
                cnt++;
            }
        }
    }
}
