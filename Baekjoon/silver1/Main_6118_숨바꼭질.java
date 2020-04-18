package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_6118_숨바꼭질 {
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
            return String.valueOf(v + 1) + " " + String.valueOf(w);
        }
    }

    static ArrayList<Node>[] nodeList;
    static PriorityQueue<Node> pq;
    static int V, E;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int[] D = new int[V + 1];
        for (int i = 2; i < V + 1; i++) {
            D[i] = Integer.MAX_VALUE;
        }
        nodeList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            nodeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeList[a].add(new Node(b, 1));
            nodeList[b].add(new Node(a, 1));
        }
        pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (Node next : nodeList[curNode.v]) {
                if(D[next.v] > D[curNode.v] + next.w){
                    D[next.v] = D[curNode.v] + next.w;
                    pq.offer(new Node(next.v , D[next.v]));
                }
            }
        }

        int num = 1;
        int max = 0;
        int cnt = 1;
        for (int i = 2; i < V+1; i++) {
            if (max < D[i]) {
                max = D[i];
                num = i;
                cnt = 1;
            } else if (max == D[i]) {
                cnt++;
            }
        }
        System.out.println((num) + " " + max + " " + cnt);
    }
}
