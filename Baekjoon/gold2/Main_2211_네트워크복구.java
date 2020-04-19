package gold2;

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2211_네트워크복구 {
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
            return String.valueOf(w);
        }
    }

    static PriorityQueue<Node> pq;
    static ArrayList<Node>[] nodeList;
    static Node[] D;
    static int[] parent;
    static int V, E;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[V + 1];
        parent = new int[1001];
        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodeList[a].add(new Node(b, c));
            nodeList[b].add(new Node(a, c));
        }

        dijkstra();

        System.out.println(V-1);
        for (int i = 2; i <= V; i++) {
            System.out.println(parent[i] + " " + i);
        }
    }

    private static void dijkstra() {
        pq = new PriorityQueue<>();
        D = new Node[V + 1];
        for (int i = 1; i <= V; i++) {
            if (i == 1)
                D[i] = new Node(i, 0);
            else
                D[i] = new Node(i, Integer.MAX_VALUE);
            pq.offer(D[i]);
        }

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            for (Node next : nodeList[curNode.v]) {
                if(D[next.v].w > D[curNode.v].w + next.w){
                    D[next.v].w = D[curNode.v].w + next.w;
                    pq.offer(D[next.v]);
                    parent[next.v] = curNode.v;
                }
            }
        }
    }
}
