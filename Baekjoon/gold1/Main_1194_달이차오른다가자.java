package gold1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
    static class Minsik {
        int row, col, keys;
        int depth;

        public Minsik(int row, int col, int keys, int depth) {
            this.row = row;
            this.col = col;
            this.keys = keys;
            this.depth = depth;
        }
    }

    static int R, C, A;
    static char[][] map;
    static boolean[][][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 맵의 크기를 동적으로 생성
        map = new char[R][];
        visit = new boolean[R][C][];

        Minsik minsik = null;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (minsik == null && map[i][j] == '0') {
                    // 현재 key는 아무것도 안가지고 있으며,
                    // 지나간 곳도 한곳도 없음
                    minsik = new Minsik(i, j, 0, 0);
                }
                // 키는 a-f까지 6개 각자리를 비트마스킹 할 것
                visit[i][j] = new boolean[0b111111 + 1];
            }
        }
        // 맵 확인
        /*for(char[] row: map){
            System.out.println(Arrays.toString(row));
        }*/

        A = Integer.MAX_VALUE;

        bfs(minsik);

        System.out.println(A == Integer.MAX_VALUE ? -1 : A);
    }

    private static void bfs(Minsik minsik) {
        Queue<Minsik> queue = new LinkedList<>();
        queue.offer(minsik);
        // 현재 위치에서 현재 가지고있는 키로 방문 체크
        visit[minsik.row][minsik.col][minsik.keys] = true;

        while (!queue.isEmpty()) {
            Minsik curMinsik = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curMinsik.row + dir[i][0];
                int nc = curMinsik.col + dir[i][1];
                int nk = curMinsik.keys;

                // 범위 밖으로 빠져나갔으며, 벽이라면 다음 계속 탐색
                if (isOut(nr, nc) || map[nr][nc] == '#')
                    continue;

                if (map[nr][nc] == '1') {
                    A = curMinsik.depth + 1;
                    return;
                }

                if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') { // 대문이라면
                    if ((curMinsik.keys & (1 << (map[nr][nc] - 'A'))) == 0) {
                        // map[nr][nr] - 'A' => 지금 대문의 번호를
                        // 1 << 하게되면 fedcba 위치의 비트를 가지므로 & 해서 0이라면 키가 없다는 의미므로 다음 탐색
                        continue;
                    }
                }
                if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') { // 키 값이라면
                    // map[nr][nc] - 'a' => 지금 열쇠의 번호를
                    // 1 << 하게되면 fedcba 위치에서 갖고 있든 안갖고있든 | 해서 가지게 함
                    nk = curMinsik.keys | (1 << (map[nr][nc] - 'a'));
                }

                // 그 열쇠를 들고 방문한 적이 있다면 다음 탐색
                if (visit[nr][nc][nk])
                    continue;

                queue.offer(new Minsik(nr, nc, nk, curMinsik.depth + 1));
                visit[nr][nc][nk] = true;
            }
        }
    }

    private static boolean isOut(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= R || nc >= C;
    }
}