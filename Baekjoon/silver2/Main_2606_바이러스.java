package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[] visit;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            map[node][nextNode] = 1;
            map[nextNode][node] = 1;
        }

        bfs(1);
        System.out.println(result);
    }

    private static void bfs(int cur) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visit[cur] = true;
        while(!queue.isEmpty()){
            cur = queue.poll();
            for (int i = 1; i < N+1; i++) {
                if(map[cur][i] == 1 && !visit[i]){
                    queue.offer(i);
                    visit[i] = true;
                    result++;
                }
            }
        }
    }
}
