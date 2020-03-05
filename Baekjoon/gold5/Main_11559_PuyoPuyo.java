package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_11559_PuyoPuyo {
    static int rowN, colN, result, cnt;
    static boolean flag;
    static LinkedList<int[]> queue;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        rowN = 12;
        colN = 6;
        map = new char[rowN][colN];
        visit = new boolean[rowN][colN];
        for (int i = 0; i < rowN; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 처리
        solution();

        // 출력
        System.out.println(result);
    }

    private static void solution() {
        while (check()) {
            // .이 아닌놈들이 있다면
            flag = false;
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    char removeIndex = map[i][j];
                    if (removeIndex != '.') {
                        cnt = 0;
                        queue = new LinkedList<>();
                        dfs(i, j, removeIndex);
                    }
                }
            }
            // 내리기
            for (int i = 0; i < colN; i++) {
                int swapArr = 0;
                ArrayList<Character> arr = new ArrayList<>();
                for (int j = rowN - 1; j > -1; j--) {
                    if (map[j][i] != '.') {
                        arr.add(map[j][i]);
                        map[j][i] = '.';
                    }
                }
                for (int j = rowN - 1; j > rowN - arr.size() - 1; j--) {
                    map[j][i] = arr.get(swapArr++);
                }
            }
            if(!flag) {
                break;
            }
            result++;
            visit = new boolean[rowN][colN];
        }
    }

    private static void dfs(int row, int col, char removeIndex) {
        cnt++;
        visit[row][col] = true;
        queue.offer(new int[]{row, col});
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if (nr > -1 && nc > -1 && nr < rowN && nc < colN && !visit[nr][nc] && map[nr][nc] == removeIndex) {
                dfs(nr, nc, removeIndex);
            }
        }

        if (cnt > 3) {
            flag = true;
            for (int[] loc : queue) {
                map[loc[0]][loc[1]] = '.';
            }
        }
    }

    private static boolean check() {
        char checkIndex = '.';
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (map[i][j] != checkIndex) {
                    return true;
                }
            }
        }
        return false;
    }
}
