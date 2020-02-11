import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_5656_벽돌깨기 {
    static int[] permutation;
    static int[][] originMap;
    static int[][] map;
    static int N;
    static int W, H;
    static int min = Integer.MAX_VALUE;
    static int tempMin;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] test = {2, 2};
    static int temp = 0;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/swea/5656_벽돌 깨기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            permutation = new int[N];
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            originMap = new int[H][W];
            map = new int[H][W];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    originMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            run(0);

            // 출력
            System.out.println("#" + testcase + " " + min);
        }
    }

    public static void init() {
        for (int i = 0; i < H; i++) {
            map[i] = originMap[i].clone();
        }
    }

    public static void run(int cnt) {
        if (cnt == N) {
            init();
            for (int i : permutation) {
                int cur_b_w = i;
                int cur_b_h = 0;
                while (true) {
                    if (cur_b_h > -1 && cur_b_h < H && cur_b_w > -1 && cur_b_w < W && map[cur_b_h][cur_b_w] == 0) {
                        cur_b_h += dir[2][0];
                        cur_b_w += dir[2][1];
                    } else {
                        break;
                    }
                }
                if (cur_b_h > -1 && cur_b_h < H && cur_b_w > -1 && cur_b_w < W && map[cur_b_h][cur_b_w] == 1) {
                    map[cur_b_h][cur_b_w] = 0;
                } else if (cur_b_h > -1 && cur_b_h < H && cur_b_w > -1 && cur_b_w < W) {
                    if (map[cur_b_h][cur_b_w] > 1) {
                        breakWall(cur_b_h, cur_b_w);
                    }
                }

                for (int j = 0; j < W; j++) {
                    int getArr = 0;
					ArrayList<Integer> arr = new ArrayList<>();
                    for (int k = H - 1; k > -1; k--) {
                        if (map[k][j] != 0) {
                            arr.add(map[k][j]);
                            map[k][j] = 0;
                        }
                    }
                    for (int k = H - 1; k > H - arr.size() - 1; k--) {
                        map[k][j] = arr.get(getArr++);
                    }
                }
            }
            // 최종 으로 남아있는 개수 구하기
            tempMin = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] != 0)
                        tempMin++;
                }
            }
            min = Math.min(min, tempMin);

            return;
        }
        for (int i = 0; i < W; i++) {
            permutation[cnt] = i;
            run(cnt + 1);
        }
    }

    private static void breakWall(int cur_b_h, int cur_b_w) {
        int wall = map[cur_b_h][cur_b_w];
        map[cur_b_h][cur_b_w] = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < wall; i++) {
                int n_h = cur_b_h + dir[j][0] * i;
                int n_w = cur_b_w + dir[j][1] * i;
                if (n_h > -1 && n_h < H && n_w > -1 && n_w < W) {
                    if (map[n_h][n_w] > 1) {
                        breakWall(n_h, n_w);
                    } else {
                        map[n_h][n_w] = 0;
                    }
                }
            }
        }


    }
}