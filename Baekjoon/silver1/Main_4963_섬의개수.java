package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
    static int row, col, result;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            if(col == 0 && row == 0)
                break;
            map = new int[row][col];
            visit = new boolean[row][col];
            result = 0;
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] =Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(!visit[i][j] && map[i][j] == 1){
                        result++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void bfs(int r, int c) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        visit[r][c] = true;
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            r = loc[0];
            c = loc[1];
            for (int i = 0; i < 8; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= row || nc >= col)
                    continue;
                if(visit[nr][nc])
                    continue;
                if(map[nr][nc] == 0)
                    continue;
                visit[nr][nc] = true;
                queue.offer(new int[]{nr,nc});
            }
        }
    }
}
