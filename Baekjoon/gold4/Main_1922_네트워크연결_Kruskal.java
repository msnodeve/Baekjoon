package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결_Kruskal {
    static class Node implements Comparable<Node> {
        int startV, endV, value;

        public Node(int startV, int endV, int value) {
            this.startV = startV;
            this.endV = endV;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.value, node.value);
        }
    }

    static int V, E;
    static ArrayList<Node> list;
    static int[] parents, rank;
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        parents = new int[V];
        rank = new int[V];
        list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, value));
            list.add(new Node(b, a, value));
        }
        for (int i = 0; i < V; i++) {
            makeSet(i);
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
            cnt++;
            if (cnt == V - 1)
                break;
        }
        System.out.println(result);
    }

    static void makeSet(int x) {
        parents[x] = x;
    }

    static int findSet(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return findSet(parents[x]);
        }
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
