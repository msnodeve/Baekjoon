package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
    static int N, M;
    static int[] parent;
    static int[] list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new int[M];
        parent = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            makeSet(i);
        }
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    // 부모 확인
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for (int i = 0; i < M - 1; i++) {
            if (findSet(list[i]) != findSet(list[i+1])) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int findSet(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return findSet(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
/*
5
5
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
*/