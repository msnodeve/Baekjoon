package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1647_도시분할계획_Prim {

    static class Edge {
        int endV;
        int value;

        public Edge(int endV, int value) {
            this.endV = endV;
            this.value = value;
        }
    }

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

    static int V, E;
    static ArrayList<Edge>[] nodeList;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList[V];
        visit = new boolean[V];
        for (int i = 0; i < V; i++) {
            nodeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            nodeList[a].add(new Edge(b, value));
            nodeList[b].add(new Edge(a, value));
        }
        int max = prim();
        System.out.println(result - max);
    }

    private static int prim() {
        int max = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visit[cur.v]) {
                visit[cur.v] = true;
                max = Math.max(cur.w, max);
                result += cur.w;
                for (int i = 0, size = nodeList[cur.v].size(); i < size; i++) {
                    Edge edge = nodeList[cur.v].get(i);
                    if (!visit[edge.endV]) {
                        pq.offer(new Node(edge.endV, edge.value));
                    }
                }
            }
        }
        return max;
    }
}
