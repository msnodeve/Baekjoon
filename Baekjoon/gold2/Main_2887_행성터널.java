package gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2887_행성터널 {
    static class Planet {
        int x, y, z, idx;

        public Planet(int x, int y, int z, int idx) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;
        }
    }

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

    static Planet[] planets;
    static int[] parent, rank;
    static int V, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        V = Integer.parseInt(br.readLine());
        parent = new int[V];
        rank = new int[V];
        planets = new Planet[V];
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            planets[i] = new Planet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Comparator<Planet> cp = Comparator.comparingInt(planet -> planet.x);
        Arrays.sort(planets, cp);
        for (int i = 1; i < V; i++) {
            pq.offer(new Node(planets[i - 1].idx, planets[i].idx, Math.abs(planets[i].x - planets[i - 1].x)));
        }
        cp = Comparator.comparingInt(planet -> planet.y);
        Arrays.sort(planets, cp);
        for (int i = 1; i < V; i++) {
            pq.offer(new Node(planets[i - 1].idx, planets[i].idx, Math.abs(planets[i].y - planets[i - 1].y)));
        }
        cp = Comparator.comparingInt(planet -> planet.z);
        Arrays.sort(planets, cp);
        for (int i = 1; i < V; i++) {
            pq.offer(new Node(planets[i - 1].idx, planets[i].idx, Math.abs(planets[i].z - planets[i - 1].z)));
        }

        for (int i = 0; i < V; i++) {
            makeSet(i);
        }
        int cnt = 0;
        while(cnt < V && !pq.isEmpty()){
            Node node = pq.poll();
            int a = findSet(node.startV);
            int b  = findSet(node.endV);
            if(a == b)
                continue;
            union(a , b);
            cnt++;
            result+= node.value;
        }

        System.out.println(result);
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
