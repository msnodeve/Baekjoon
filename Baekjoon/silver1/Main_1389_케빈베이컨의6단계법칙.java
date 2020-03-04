package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
    static int N, M, result, temp = Integer.MAX_VALUE;
    static int[][] map;
    static int[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        // 처리
        for (int i = N - 1; i > 0; i--) {
            // 1번째 사람부터 검사 시작
            int getRelation = bfs(i);
            if (temp >= getRelation) {
                temp = getRelation;
                result = i;
            }
            visit = new int[N];
        }

        //출력
        System.out.println(result);

    }

    private static int bfs(int row) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, 0});
        visit[row] = 1;
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            row = loc[0];
            int cnt = loc[1];
            cnt++;
            for (int i = 1; i < N; i++) {
                if (visit[i] == 0 && map[row][i] == 1) {
                    queue.offer(new int[]{i, cnt});
                    visit[i] = cnt;
                }
            }
        }
        int sum = -1;
        for (int i : visit) {
            sum += i;
        }
        return sum;
    }
}
