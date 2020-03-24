package gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램 {
    static class Node {
        int value;
        Node link;

        public Node(int value, Node link) {
            this.value = value;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", link=" + link +
                    '}';
        }
    }

    static int N, M, cnt;
    static int[] arrList;
    static Node[] nodeList;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrList = new int[N + 1];
        nodeList = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            String[] lines = br.readLine().split(" ");
            for (int j = 1; j < Integer.parseInt(lines[0]); j++) {
                int a = Integer.parseInt(lines[j]);
                int b = Integer.parseInt(lines[j+1]);
                nodeList[a] = new Node(b, nodeList[a]);
                arrList[b]++;
            }
        }

        // 처리
        String result = solution();

        // 출력
        if(cnt == N){
            System.out.print(result);
        }else{
            System.out.print(0);
        }
    }

    private static String solution() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arrList[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int next = queue.poll();
            cnt++;
            sb.append(next + "\n");
            Node nextNode = nodeList[next];
            while (nextNode != null) {
                int cnt = --arrList[nextNode.value];
                if (cnt == 0) {
                    queue.add(nextNode.value);
                }
                nextNode = nextNode.link;
            }
        }
        return sb.toString();
    }
}
