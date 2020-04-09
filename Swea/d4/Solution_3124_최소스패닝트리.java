package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class Solution_3124_최소스패닝트리 {
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
    static ArrayList<Node>[] nodeList;
    static boolean[] visit;
    static long result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visit = new boolean[V+1];
            result = 0;
            nodeList = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++)
                nodeList[i] = new ArrayList<>();

            // 간선의 정보를 받는다.
            for (int i = 1; i <= E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                nodeList[a].add(new Node(a, b, c));
                nodeList[b].add(new Node(b, a, c));
            }

            mst();

            System.out.println("#" + testcase + " " + result);
        }

    }
    private static void mst() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value > o2.value ? 1 : -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        ArrayList<Node> tempList;
        Node tempNode;
        while (!dq.isEmpty()) {
            int curNode = dq.poll();
            visit[curNode] = true;
            tempList = nodeList[curNode];
            for (int i = 0; i < tempList.size(); i++) {
                if (!visit[tempList.get(i).endV]) {
                    pq.add(tempList.get(i));
                }
            }

            while (!pq.isEmpty()) {
                tempNode = pq.poll();
                if (!visit[tempNode.endV]) {
                    visit[tempNode.endV] = true;
                    result += tempNode.value;
                    dq.add(tempNode.endV);
                    break;
                }
            }
        }
    }
}
