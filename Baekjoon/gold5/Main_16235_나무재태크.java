package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

// 0 각 맵의 S2D2가 겨울에 추가할 양분의 양을 저장할자료 (2차원)
// 0 각 맵의 현재 양분양을 저장할 자료 (2차원)
// 1 현재 살아있는 모든 나무를 담을 Priority Queue (좌표, 나이)
// 2 봄이 지나 살아있는 나무들이 모여있을 큐
// 3 봄이 지나 죽을 나무들이 모여있을 큐

// 봄 : 1을 하나씩 꺼내며 산놈은 2로 죽은놈은 3으로
// 여름 : 2를 모두 꺼내며 양분추가 처리
// 가을 : 3을 모두 꺼내며 8방에 생기는 나무를 다시 1에 삽입
// 겨울 : 0을 한바퀴 돌면서 양분 업데이트

public class Main_16235_나무재태크 {
    static class Tree implements Comparable<Tree> {
        int r, c, age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Tree{" + "r=" + r + ", c=" + c + ", age=" + age + '}';
        }

        @Override
        public int compareTo(Tree tree) {
            return Integer.compare(this.age, tree.age);
        }
    }

    static int[][] s2d2; // s2d2가 겨울에 뿌릴 양분의 양
    static int[][] map; // 각 칸별로의 현재 양분의 양
    static PriorityQueue<Tree> trees; // 현재 살아 있는 모든 나무들
    static Queue<Tree> alive; // 봄을 지나 살아남은 나무들이 잠시 머물 곳
    static Queue<Tree> dead; // 봄을 지나 죽은 나무들이 잠시 머물 곳
    static int N, M, K;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        alive = new LinkedList<>();
        dead = new LinkedList<>();
        trees = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        s2d2 = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                s2d2[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.offer(new Tree(x, y, z));
        }

        // 처리
        for (int k = 0; k < K; k++) {
            // 봄
            spring();
            // 여름
            summer();
            // 가을
            autumn();
            // 겨울
            winter();
        }

        System.out.println(trees.size());
    }

    static void spring() {
        // trees 큐를 하나씩 꺼내면서
        while (!trees.isEmpty()) {
            Tree tree = trees.poll();
            // 나무의 위치에 양분이 충분하다면 나무의 나이만큼 양분을 없애고 나이한살 늘리고 alive 큐로 삽입
            if (map[tree.r][tree.c] >= tree.age) {
                map[tree.r][tree.c] -= tree.age;
                tree.age++;
                alive.offer(tree);
            }
            // 아니라면 dead 큐로 삽입
            else {
                dead.offer(tree);
            }
        }
    }

    static void summer() {
        // dead 큐를 모두 돌면서, 나무의 나이의 반만큼 나무의 위치에 양분 누적합
        while (!dead.isEmpty()) {
            Tree tree = dead.poll();
            map[tree.r][tree.c] += tree.age >> 1;
        }
    }

    static void autumn() {
        // alive 큐를 모두 돌면서, 나이가 5의 배수라면 8방에 대해서 나무를 생성해 trees에 삽입, 현재 나무도 삽입
        while (!alive.isEmpty()) {
            Tree tree = alive.poll();
            trees.offer(tree);
            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = tree.r + dir[i][0];
                    int nc = tree.c + dir[i][1];
                    if (nr < 1 || nc < 1 || nr > N || nc > N)
                        continue;
                    trees.offer(new Tree(nr, nc, 1));
                }
            }
        }
    }

    static void winter() {
        // N * N 을 탐색하면 map의 각 자리에 s2d2의 각 자리 값만큼을 누적합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += s2d2[i][j];
            }
        }
    }
}
