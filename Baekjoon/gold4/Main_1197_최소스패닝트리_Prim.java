package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1197_최소스패닝트리_Prim {

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
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visit = new boolean[V+1];
        nodeList = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++)
            nodeList[i] = new ArrayList<>();
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodeList[a].add(new Node(a, b, c));
            nodeList[b].add(new Node(b, a, c));
        }

        mst();
        System.out.println(result);
    }

    private static void mst() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.value, n2.value);
            }
        });

        pq.offer(new Node(1,1,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(!visit[cur.startV]){
                visit[cur.startV] = true;
                result+= cur.value;

                for (int i = 0, size = nodeList[cur.startV].size(); i < size; i++) {
                    Node temp = nodeList[cur.startV].get(i);
                    if(!visit[temp.endV]){
                        pq.offer(new Node(temp.endV, temp.endV, temp.value));
                    }
                }
            }
        }
    }
}
