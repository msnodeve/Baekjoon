package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1197_최소스패닝트리_Kruskal {

    public static class Node {
        int startV, endV;
        int value;

        public Node(int startV, int endV, int value) {
            this.startV = startV;
            this.endV = endV;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "startV=" + startV +
                    ", endV=" + endV +
                    ", value=" + value +
                    '}';
        }
    }

    static int V, E;
    static ArrayList<Node> nodeList;
    static int[] parents;
    static int[] rank;
    static long result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList<>();
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(a, b, c));
            nodeList.add(new Node(b, a, c));
        }

        parents = new int[V + 1];
        rank = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            makeSet(i);
        }
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return Integer.compare(node.value, t1.value);
            }
        });

        int cnt = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            int a = findSet(nodeList.get(i).startV);
            int b = findSet(nodeList.get(i).endV);
            if(a == b)
                continue;
            union(a, b);
            result += nodeList.get(i).value;
            cnt++;
            if(cnt == V-1)
                break;
        }

        System.out.println(result);
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
