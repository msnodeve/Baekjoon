package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_6497_전력난_Prim {
    static class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
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

    static ArrayList<Edge>[] nodeList;
    static boolean[] visit;
    static int V, E;
    static int result;
    static int total;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if (V == 0 && E == 0)
                break;

            result = 0;
            total = 0;
            nodeList = new ArrayList[V];
            visit = new boolean[V];
            for (int i = 0; i < V; i++) {
                nodeList[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                nodeList[a].add(new Edge(b, v));
                nodeList[b].add(new Edge(a, v));
                total += v;
            }

            prim();
            System.out.println(total - result);
        }
    }

    private static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visit[cur.v]) {
                visit[cur.v] = true;
                result += cur.w;
                for (int i = 0, size = nodeList[cur.v].size(); i < size; i++) {
                    Edge edge = nodeList[cur.v].get(i);
                    if (!visit[edge.v]) {
                        pq.offer(new Node(edge.v, edge.w));
                    }
                }
            }
        }
    }
}
