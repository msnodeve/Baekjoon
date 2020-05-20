package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5014_스타트링크 {
    static int F, S, G, U, D;
    // F : 총 건물의 층
    // S : 강호가 있는 층
    // G : 목표 층
    // U : 올라가는 층 수
    // D : 내려가는 층 수

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int result = solution();
        System.out.println(result != -1 ? result : "use the stairs");
    }

    private static int solution() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[F + U + 1];
        visit[S] = true;
        queue.offer(new int[]{S, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curFloor = current[0];
            int cnt = current[1];

            if(curFloor == G)
                return cnt;

            int nextUpFloor = curFloor + U;
            // 총 층수를 넘어가지 않았다면
            if (nextUpFloor <= F && U != 0 && !visit[nextUpFloor]) {
                queue.offer(new int[]{nextUpFloor, cnt + 1});
                visit[nextUpFloor] = true;
            }

            int nextDownFloor = curFloor - D;
            // 제일 하단층을 넘어가지 않았다면
            if (nextDownFloor >= 1 && D != 0 && !visit[nextDownFloor]) {
                queue.offer(new int[]{nextDownFloor, cnt + 1});
                visit[nextDownFloor] = true;
            }
        }
        return -1;
    }
}