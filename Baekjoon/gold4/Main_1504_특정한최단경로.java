package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1504_특정한최단경로 {
    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.w, node.w);
        }
    }

    private static final int INF = 200000000;
    static int N, E;
    static int v1, v2;
    static List<Node>[] list;
    static PriorityQueue<Node> pq;
    static int[] D;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        D = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, v));
            list[b].add(new Node(a, v));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        if(result1 >= INF && result2 >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(result1, result2));
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(D, INF);
        D[start] = 0;
        pq = new PriorityQueue<>();
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