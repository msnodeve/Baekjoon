package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

class Node{
    int startVertex, endVertex;
    double value;
    public Node(int startVertex, int endVertex, double value) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "startVertex=" + startVertex +
                ", endVertex=" + endVertex +
                ", value=" + value +
                '}';
    }
}

public class Solution_1251_하나로 {
    static int N;
    static double result;
    static int[] x, y;
    static double E;
    static ArrayList<Node>[] nodeList;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        NumberFormat f = NumberFormat.getInstance();
        f.setGroupingUsed(false);
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = 0;
            N = Integer.parseInt(br.readLine());
            x = new int[N];
            y = new int[N];
            StringTokenizer st  = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st  = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            E = Double.parseDouble(br.readLine());
            visit = new boolean[N];
            nodeList = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                nodeList[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j)
                        continue;
                    double value = Math.sqrt(Math.pow(Math.abs(y[j]-y[i]),2) + Math.pow(Math.abs(x[j]-x[i]),2));
                    nodeList[i].add(new Node(i,j,value));
                }
            }

            // 처리
            mst();
//            for (int i = 0; i < nodeList.length; i++) {
//                for (int j = 0; j < nodeList[i].size(); j++) {
//                    System.out.println(nodeList[i].get(j).toString());
//                }
//            }
            // 출력
            System.out.println("#" + testcase + " " +  f.format(Math.round(result)));
        }
    }

    private static void mst() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value > o2.value ? 1 : -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        ArrayList<Node> tempList;
        Node tempNode;
        while(!dq.isEmpty()){
            int curNode = dq.poll();
            visit[curNode] = true;
            tempList = nodeList[curNode];
            for (int i = 0; i < tempList.size(); i++) {
                if(!visit[tempList.get(i).endVertex]){
                    pq.add(tempList.get(i));
                }
            }

            while(!pq.isEmpty()){
                tempNode = pq.poll();
                if(!visit[tempNode.endVertex]){
                    visit[tempNode.endVertex] = true;
                    result += Math.pow(tempNode.value, 2) * E;
                    dq.add(tempNode.endVertex);
                    break;
                }
            }
        }
    }
}
