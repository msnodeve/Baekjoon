package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686_치킨배달 {

    static int N, M, result;
    static int[][] map;
    static List<int[]> list_1, list_2;

    static int count_2;
    static int[] number;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list_1 = new ArrayList<>();
        list_2 = new ArrayList<>();
        result = Integer.MAX_VALUE;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    list_2.add(new int[]{i, j});
                    count_2++;
                } else if (value == 1) {
                    map[i][j] = value;
                    list_1.add(new int[]{i, j});
                }
            }
        }

        // 처리
        number = new int[M];
        combination(count_2, M);

        System.out.println(result);
    }

    private static void combination(int cnt, int cur) {
        if (cur == 0) {
            for (int num : number) {
                int[] nums = list_2.get(num);
                map[nums[0]][nums[1]] = 2;
            }
            int temp = 0;
            for (int[] search : list_1) {
                temp += bfs(search[0], search[1], 0);
            }
            result = Math.min(temp , result);

            for (int num : number) {
                int[] nums = list_2.get(num);
                map[nums[0]][nums[1]] = 0;
            }
            return;
        }
        if (cnt < cur)
            return;

        number[cur - 1] = cnt - 1;
        combination(cnt - 1, cur - 1);
        combination(cnt - 1, cur);
    }

    private static int bfs(int row, int col, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        visit[row][col] = true;
        queue.offer(new int[]{row, col, cnt});

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            row = loc[0];
            col = loc[1];
            cnt = loc[2];

            if (map[row][col] == 2)
                return cnt;

            for (int i = 0; i < 4; i++) {
                int nr = row + dir[i][0];
                int nc = col + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
                    continue;

                visit[nr][nc] = true;
                queue.offer(new int[]{nr, nc, cnt + 1});
            }
        }
        return cnt;
    }
}