package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_2112_보호필름 {
    static int D, W, K; // 두께, 가로크기, 합격기준
    static int[][] map;
    static int[] list;
    static int min; // 최소 비용 회수

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken()); // 두께
            W = Integer.parseInt(st.nextToken()); // 가로크기
            K = Integer.parseInt(st.nextToken()); // 합격기준

            min = Integer.MAX_VALUE;
            map = new int[D][W]; // 맵 크기 생성
            list = new int[D];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 맵 확인
            /*for(int[] row :map){
                System.out.println(Arrays.toString(row));
            }*/

            solution(0, 0);
            System.out.println("#" + testcase + " " + min);
        }
    }

    private static void solution(int row, int count) {
        if (row == D) {
            if (check()) {
                min = Math.min(min, count);
            }
            return;
        }

        if (count >= min)
            return;

        // 투약하지 않은 경우
        list[row] = 0;
        solution(row + 1, count);

        // A 투약한 경우
        list[row] = 1;
        solution(row + 1, count + 1);

        // B 투약한 경우
        list[row] = 2;
        solution(row + 1, count + 1);
    }

    private static boolean check() {
        int count, cur, next;

        for (int i = 0; i < W; i++) {
            count = 1;
            for (int j = 0; j < D - 1; j++) {
                cur = map[j][i];
                next = map[j + 1][i];

                if (list[j] > 0) { // 약품 투여가 되어있는 상황
                    cur = list[j] - 1;
                }
                if (list[j + 1] > 0) { // 약품 투여가 되어있는 상황
                    next = list[j + 1] - 1;
                }
                if (cur == next) {
                    count++;
                    if (count >= K)
                        break;
                }else{
                    count = 1;
                }
            }
            if(count < K)
                return false;
        }
        return true;
    }
}
