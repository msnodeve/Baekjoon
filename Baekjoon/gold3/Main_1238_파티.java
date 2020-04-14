package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1238_파티 {
    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.w, node.w);
        }

        @Override
        public String toString() {
            return w + "";
        }
    }

    static PriorityQueue<Node> pq;
    static int N, M, X;
    static List<Node>[] list;
    static int[] D;
    static int max;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        D = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, v));
        }
        int result[] = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            result[i] = dijkstra(i, X) + dijkstra(X, i);
            max = Math.max(result[i], max);
        }
        System.out.println(max);
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(D, Integer.MAX_VALUE);
        pq = new PriorityQueue<>();
        D[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (Node next : list[curNode.v]) {
                if (D[next.v] > D[curNode.v] + next.w) {
                    D[next.v] = D[curNode.v] + next.w;
                    pq.add(new Node(next.v, D[next.v]));
                }
            }
        }
        return D[end];
    }
}