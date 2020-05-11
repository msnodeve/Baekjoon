package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
    static int[] parent;
    static int n, m;
    static StringBuilder result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            makeSet(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int parentNum = Integer.parseInt(st.nextToken());
            int childNum = Integer.parseInt(st.nextToken());

            solution(command, parentNum, childNum);
        }
        System.out.println(result.toString());
    }

    private static void solution(int command, int parentNum, int childNum) {
        switch (command){
            case 0:
                union(parentNum, childNum);
                break;
            case 1:
                if(findSet(parentNum) == findSet(childNum)){
                    result.append("YES").append('\n');
                }else{
                    result.append("NO").append('\n');
                }
                break;
        }
    }

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int findSet(int x) {
        if (parent[x] == x)
            return x;
        else
            return findSet(parent[x]);
    }

    static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if(x == y)
            return;
        parent[y] = x;
    }
}
