package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10282_해킹 {
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

    static int V, E, result, maxTime, startV;
    static ArrayList<Node>[] nodeList;
    static Node[] D;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            startV = Integer.parseInt(st.nextToken());
            nodeList = new ArrayList[V + 1];
            result = 0;
            maxTime = 0;
            D = new Node[V + 1];
            for (int i = 1; i < V + 1; i++)
                nodeList[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                nodeList[b].add(new Node(a, c));
            }

            dijkstra();
            getMaxTime();
            System.out.println(result + " " + maxTime);
            for (int i = 1; i < V + 1; i++) {
                System.out.print(D[i].w + " ");
            }
            System.out.println();
        }

    }

    private static void getMaxTime() {
        for (int i = 1; i < V + 1; i++) {
            if (D[i].w != 987654321) {
                result++;
                maxTime = Math.max(maxTime, D[i].w);
            }
        }
    }

    private static void dijkstra() {
        pq = new PriorityQueue<>();
        for (int i = 1; i < V + 1; i++) {
            if (i == startV)
                D[i] = new Node(i, 0);
            else
                D[i] = new Node(i, 987654321);
            pq.offer(D[i]);
        }

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (Node next : nodeList[curNode.v]) {
                if (D[next.v].w > D[curNode.v].w + next.w) {
                    D[next.v].w = D[curNode.v].w + next.w;
                    pq.offer(D[next.v]);
                }
            }
        }
    }
}