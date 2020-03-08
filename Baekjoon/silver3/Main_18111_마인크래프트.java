package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_18111_마인크래프트 {
    static int N, M, B, result, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        // 처리
        int cnt = solution();
        System.out.println(cnt + " " + result);
    }

    private static int solution() {
        int cnt = Integer.MAX_VALUE;
        for (int destinationBlock = min; destinationBlock <= max; destinationBlock++) {
            int tempCnt = 0;
            int tempBlock = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int divMap = destinationBlock - map[i][j];
                    if (divMap > 0) {
                        tempCnt += Math.abs(divMap);
                        tempBlock += Math.abs(divMap);
                    } else if (divMap < 0) {
                        tempCnt += 2 * Math.abs(divMap);
                        tempBlock -= Math.abs(divMap);
                    }
                }
            }

            if (B >= tempBlock) {
                if(cnt >= tempCnt){
                    cnt = tempCnt;
                    result = destinationBlock;
                }
            }
        }
        return cnt;
    }
}