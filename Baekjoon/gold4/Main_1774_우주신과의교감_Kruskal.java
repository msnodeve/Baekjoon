package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1774_우주신과의교감_Kruskal {

    static class Node implements Comparable<Node> {
        int startV, endV;
        double value;

        public Node(int startV, int endV, double value) {
            this.startV = startV;
            this.endV = endV;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return Double.compare(this.value, node.value);
        }
    }

    static int V, E;
    static double result;
    static int[] x, y;
    static int[] parents;
    static int[] rank;
    static ArrayList<Node> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V];
        rank = new int[V];
        x = new int[V];
        y = new int[V];
        list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // 처리
        for (int i = 0; i < V; i++) {
            makeSet(i);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                double value = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                list.add(new Node(i, j, value));
                list.add(new Node(j, i, value));
            }
        }
        Collections.sort(list);
        int cnt = 0;
        for (Node node : list) {
            int a = findSet(node.startV);
            int b = findSet(node.endV);
            if (a == b)
                continue;
            union(a, b);
            result += node.value;
            if (cnt == V - E - 1)
                break;
        }

        // 출력
        System.out.printf("%.2f", result);
    }

    static void makeSet(int x) {
        parents[x] = x;
    }

    static int findSet(int x) {
        if (x == parents[x])
            return x;
        else
            return findSet(parents[x]);
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (rank[px] > rank[py]) {
            parents[py] = px;
        } else {
            parents[px] = py;
            if (rank[px] == rank[py]) {
                rank[py]++;
            }
        }
    }
}
