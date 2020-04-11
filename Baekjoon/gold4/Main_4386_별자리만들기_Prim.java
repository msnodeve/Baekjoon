package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기_Prim {

    static class Edge {
        int endV;
        double value;

        public Edge(int endV, double value) {
            this.endV = endV;
            this.value = value;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        double w;

        public Node(int v, double w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return Double.compare(this.w, node.w);
        }
    }

    static int N;
    static ArrayList<Edge>[] nodeList;
    static double[] x, y;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[N];
        x = new double[N];
        y = new double[N];
        for (int i = 0; i < N; i++)
            nodeList[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double value = Math.sqrt(Math.pow(Math.abs(y[j] - y[i]), 2) + Math.pow(Math.abs(x[j] - x[i]), 2));
                nodeList[i].add(new Edge(j, value));
                nodeList[j].add(new Edge(i, value));
            }
        }
        // 처리

        System.out.printf("%.2f", mst());
    }

    private static double mst() {
        double result = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N];
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!visit[cur.v]) {
                visit[cur.v] = true;
                result += cur.w;

                for (int i = 0, size = nodeList[cur.v].size(); i < size; i++) {
                    Edge temp = nodeList[cur.v].get(i);
                    if (!visit[temp.endV]) {
                        pq.offer(new Node(temp.endV, temp.value));
                    }
                }
            }
        }
        return result;
    }
}
