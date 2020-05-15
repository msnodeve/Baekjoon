package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1516_게임개발 {
    static int N;
    static int[] times, inDegree, result;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        times = new int[N + 1];// 각 노드가 걸리는 시간을 저장할 배열
        result = new int[N + 1];
        inDegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int value;
            while ((value = Integer.parseInt(st.nextToken())) != -1) {
                list[value].add(i);
                inDegree[i]++;
            }
        }

        // 확인
//        System.out.println(Arrays.toString(times));
//        System.out.println(Arrays.toString(inDegree));
//        for (List<Integer> l : list) {
//            System.out.println(l);
//        }

        solution();
        for (int i = 1; i < N + 1; i++) {
            System.out.println(result[i] + times[i]);
        }
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i : list[cur]) {
                int next = i;
                result[next] = Math.max(result[next], result[cur] + times[cur]);
                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}