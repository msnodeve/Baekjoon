package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10451_순열사사이클 {
    static int N, result;
    static boolean[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = 0;
            N = Integer.parseInt(br.readLine())+1;
            map = new boolean[N][N];
            visit = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N; i++) {
                map[i][Integer.parseInt(st.nextToken())] = true;
            }

            // 처리
            for (int i = 1; i < N; i++) {
                if(!visit[i]) {
                    result++;
                    bfs(i);
                }
            }

            // 출력
            System.out.println(result);
        }
    }

    private static void bfs(int pibot) {
        LinkedList<Integer>queue = new LinkedList<>();
        queue.offer(pibot);
        visit[pibot] = true;
        while(!queue.isEmpty()){
            int loc = queue.poll();
            for (int i = 1; i < N; i++) {
                if(!visit[i] && map[loc][i]){
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
