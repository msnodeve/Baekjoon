package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
    static int rowN, colN;
    static int[][] map, temp;
    static boolean[][] visit;
    static int result;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = System.currentTimeMillis();
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        temp = new int[rowN][colN];
        visit = new boolean[rowN][colN];
        for (int i = 0; i < rowN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리
        solution();

        // 출력
    }

    private static void solution() {
        int year = 0;
        // 2분할 되었다면 종료시킬 것임
        while (true) {
            // 2분할 이상 되어있는지 검사
            int count = 0;
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    if (!visit[i][j] && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            if(count == 0) {
                System.out.println(0);
                return;
            } else if(count >= 2) {
                System.out.println(year);
                return;
            }
            // 빙산 녹이기
            for (int i = 0; i < rowN; i++) {
                for (int j = 0; j < colN; j++) {
                    if(map[i][j] - temp[i][j] < 0){
                        map[i][j] = 0;
                    }else{
                        map[i][j] = map[i][j] - temp[i][j];
                    }
                    visit[i][j] = false;
                    temp[i][j] = 0;
                }
            }
            // 년도++
            year++;
        }
    }

    private static void dfs(int row, int col) {
        visit[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if (nr > -1 && nc > -1 && nr < rowN && nc < colN) {
                if (map[nr][nc] == 0) {
                    temp[row][col]++;
                }
                if (!visit[nr][nc] && map[nr][nc] != 0) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
