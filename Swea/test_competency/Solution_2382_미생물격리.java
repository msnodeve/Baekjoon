package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_2382_미생물격리 {

    static class Node {
        int value, maxValue, direction;

        public Node(int value, int maxValue, int direction) {
            this.value = value;
            this.maxValue = maxValue;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    static class Virus {
        int row, col, value, direction;

        public Virus(int row, int col, int value, int direction) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Virus{" +
                    "row=" + row +
                    ", col=" + col +
                    ", value=" + value +
                    ", direction=" + direction +
                    '}';
        }
    }

    static HashMap<Integer, int[]> hashMap;
    static int N, M, K, result;
    static Node[][] map;
    static Queue<Virus> queue;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hashMap = new HashMap<>();
        hashMap.put(1, new int[]{-1, 0}); // 상
        hashMap.put(2, new int[]{1, 0}); // 하
        hashMap.put(3, new int[]{0, -1}); // 좌
        hashMap.put(4, new int[]{0, 1}); // 우

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                queue.offer(new Virus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // 처리
            for (int i = 0; i < M; i++) {
                solution();
                result = 0;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (map[j][k] != null) {
                            Node node = map[j][k];
                            queue.offer(new Virus(j, k, node.value, node.direction));
                            result += node.value;
                        }
                    }
                }
            }

            // 출력
            System.out.println("#" + testcase + " " + result);
        }
    }
    
    private static void solution() {
        map = new Node[N][N];
        result = 0;
        int size = queue.size();
        while (size-- > 0) {
            Virus curVirus = queue.poll();
            int curRow = curVirus.row;
            int curCol = curVirus.col;
            int curValue = curVirus.value;
            int curDirection = curVirus.direction;

            int nr = curRow + hashMap.get(curDirection)[0];
            int nc = curCol + hashMap.get(curDirection)[1];

            if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                // 약품이 칠해진 셀에 도착을 한다면
                curValue /= 2; // 2 나누기
                curDirection = convertDirection(curDirection); // 방향 반대로 바꾸기
            }

            // 약품이 칠해진 셀이 아니라면
            Node nextNode = null;
            if (map[nr][nc] == null) {
                // 아직 한번도 방문하지 않은 곳이라면
                nextNode = new Node(curValue, curValue, curDirection);
            } else {
                // 한번이라도 방문한 경우 라면
                nextNode = map[nr][nc];
                if (nextNode.maxValue < curValue) {
                    // 합쳐질 미생물이 더 크다면
                    nextNode.maxValue = curValue;
                    nextNode.value += curValue;
                    nextNode.direction = curDirection;
                } else {
                    nextNode.value += curValue;
                }
            }
            map[nr][nc] = nextNode;
        }
    }

    private static int convertDirection(int dir) {
        switch (dir) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return 0;
    }
}