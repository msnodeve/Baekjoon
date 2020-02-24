package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
    static int[][] map;
    static boolean[] visit;
    static int N, M;
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            map[num1][num2] = 1;
            map[num2][num1] = 1;
        }

        // 처리
        for (int i = 0; i < N+1; i++) {
            if(!visit[i]){
                bfs(i);
                result++;
            }
        }

        // 출력
        System.out.println(result-1);
    }

    private static void bfs(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();
            for (int j = 0; j < N+1; j++) {
                if(map[temp][j] == 1 && !visit[j]){
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
