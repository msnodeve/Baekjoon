package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16234_인구이동 {
    static class Loc {
        int r, c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static int N, L, R;
    static int[][] m;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N X N 땅의 크기
        L = Integer.parseInt(st.nextToken()); // L 이상
        R = Integer.parseInt(st.nextToken()); // R 이하

        m = new int[N][N];
        for (int i = 0; i < m.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m.length; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; // 인구 이동의 회수

        while (true) { // 인구 이동
            boolean change = false; // 인구이동 여부 체크

            // 모든 칸 순회
            // BFS 탐색 인접한 국가와 L ~ R 범위 내의 인구차
            visit = new boolean[N][N]; // 방문 여부
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    if (!visit[i][j] && search(i, j)) {
                        change = true;
                    }
                }
            }

            if (!change) {
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean search(int r, int c) {
        List<Loc> list = new ArrayList<>();
        Queue<Loc> queue = new LinkedList<>();
        Loc l = new Loc(r, c);
        list.add(l);
        queue.offer(l);
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            l = queue.poll();
            r = l.r;
            c = l.c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc])
                    continue;

                if (diff(m[nr][nc], m[r][c])) {
                    Loc nl = new Loc(nr, nc);
                    list.add(nl);
                    queue.offer(nl);
                    visit[nr][nc] = true;
                }
            }
        }

        // 인접 국가 개수가 2개 이상이면 인구 이동 발생
        if (list.size() >= 2) {
            int total = 0;
            for (Loc loc : list) {
                total += m[loc.r][loc.c];
            }
            int avg = total / list.size();
            for (Loc loc : list) {
                m[loc.r][loc.c] = avg;
            }
            return true;
        }

        return false; // 인구 이동 없으면
    }

    private static boolean diff(int next, int cur) {
        int sub = next >= cur ? next - cur : cur - next;
        return L <= sub && sub <= R;
    }

}
