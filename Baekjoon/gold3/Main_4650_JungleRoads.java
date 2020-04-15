package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4650_JungleRoads {
    static class Node implements Comparable<Node> {
        int startV, endV, w;

        public Node(int startV, int endV, int w) {
            this.startV = startV;
            this.endV = endV;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.w, node.w);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "startV=" + startV +
                    ", endV=" + endV +
                    ", w=" + w +
                    '}';
        }
    }

    static ArrayList<Node> list;
    static int[] parent, rank;
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int V = Integer.parseInt(br.readLine());
            if (V == 0)
                break;
            list = new ArrayList<>();
            parent = new int[V];
            rank = new int[V];
            result = 0;
            for (int i = 0; i < V; i++)
                makeSet(i);
            for (int i = 0; i < V - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int startV = st.nextToken().charAt(0) - 'A';
                st.nextToken();
                while (st.hasMoreTokens()) {
                    int endV = st.nextToken().charAt(0) - 'A';
                    int value = Integer.parseInt(st.nextToken());
                    list.add(new Node(startV, endV, value));
                    list.add(new Node(endV, startV, value));
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
                result += node.w;
                cnt++;
                if (cnt == V - 1) {
                    break;
                }
            }
            System.out.println(result);
        }
    }

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int findSet(int x) {
        if (x == parent[x])
            return x;
        else
            return findSet(parent[x]);
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[px] = py;
            if (rank[px] == rank[py]) {
                rank[py]++;
            }
        }
    }
}