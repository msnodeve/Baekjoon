package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2583_영역구하기 {
    static int rowN, colN, K, result, cnt;
    static ArrayList<Integer> widthRet;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowN = Integer.parseInt(st.nextToken());
        colN = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        visit = new boolean[rowN][colN];
        widthRet = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startRectY = Integer.parseInt(st.nextToken());
            int startRectX = Integer.parseInt(st.nextToken());
            int endRectY = Integer.parseInt(st.nextToken());
            int endRectX = Integer.parseInt(st.nextToken());
            for (int k = startRectX; k < endRectX; k++) {
                for (int j = startRectY; j < endRectY; j++) {
                    map[k][j] = 1;
                }
            }
        }

        // 처리
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                // 방문하지 않았으며, 그자리가 빈공간이라면
                if (!visit[i][j] && map[i][j] == 0) {
                    result++;
                    cnt = 1;
                    dfs(i, j);
                    widthRet.add(cnt);
                }
            }
        }
        Collections.sort(widthRet);
        System.out.println(result);
        for (int i : widthRet) {
            System.out.print(i + " ");
        }
    }

    private static void dfs(int row, int col) {
        visit[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr >-1 && nc >-1 && nr < rowN && nc < colN){
                if(!visit[nr][nc] && map[nr][nc] == 0){
                    cnt++;
                    dfs(nr, nc);
                }
            }
        }
    }
}
