package gold1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5214_환승 {
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
    }

    static final int INF = 987654321;
    static int N, K, M;
    static Node[] D;
    static List<Node>[] nodeList;
    static PriorityQueue<Node> queue;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList[N + M + 1];
        for (int i = 1; i < N + M + 1; i++)
            nodeList[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int dummy = N + i;
            for (int j = 0; j < K; j++) {
                int node = Integer.parseInt(st.nextToken());
                nodeList[dummy].add(new Node(node, 1));
                nodeList[node].add(new Node(dummy, 1));
            }
        }

        // 처리
        dijkstra();

        // 출력
        System.out.println(D[N].w >= INF ? -1 : D[N].w / 2 + 1);
    }

    private static void dijkstra() {
        queue = new PriorityQueue<>();
        D = new Node[N + M + 1];
        D[1] = new Node(1, 0);
        queue.offer(D[1]);

        for (int i = 2; i < N + M + 1; i++) {
            D[i] = new Node(i, INF);
            queue.offer(D[i]);
        }

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            for (Node next : nodeList[curNode.v]) {
                if (D[next.v].w > D[curNode.v].w + next.w) {
                    D[next.v].w = D[curNode.v].w + next.w;
                    queue.offer(D[next.v]);
                }
            }
        }
    }
}