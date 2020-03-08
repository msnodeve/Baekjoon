package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2234_성곽 {
    static int rowN, colN;
    static int resultRoomCount, resultMaxRoom;
    //         방의 개수        넓은 방의 넓이
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        colN = Integer.parseInt(st.nextToken());
        rowN = Integer.parseInt(st.nextToken());
        map = new int[rowN][colN];
        visit = new boolean[rowN][colN];
        for (int i = 0; i < rowN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 처리 및 출력
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (!visit[i][j]) {
                    resultRoomCount++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(resultRoomCount);
        System.out.println(resultMaxRoom);
        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                breakWall(i, j);
            }
        }
        System.out.println(resultMaxRoom);
    }

    private static void breakWall(int row, int col) {
        // 4방향을 검사
        for (int i = 0; i < 4; i++) {
            // 지금 현재 위치가 1이라면 벽이 있다는 의미 그러므로
            if ((map[row][col] & (1 << i)) != 0) {
                for (int j = 0; j < visit.length; j++) {
                    Arrays.fill(visit[j], false);
                }
                // 오른쪽이면 오른쪽을 제거, 위쪽이면 위쪽 제거
                map[row][col] -= (1 << i);
                // 그리고 탐색시작
                bfs(row, col);
                // 탐색을 다하고 나왔을 경우 빠져나오면서 다시 그위치에 벽을 세움
                map[row][col] += (1 << i);
            }
        }
        // 이작업을 각 칸마다 검사
    }

    private static void bfs(int row, int col) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visit[row][col] = true;
        // 룸 크기를 매기기 위함
        int roomSize = 0;
        // 끝까지 탐색 시작
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int c_row = loc[0];
            int c_col = loc[1];
            int c_wall = map[c_row][c_col];
            // 현재 룸이 있다는 뜻이므로 ++
            roomSize++;
            // 동 서 남 북 4방향 검사
            for (int i = 0; i < 4; i++) {
                // 지금 맵이 1 ~ 15 자리수가 0001(왼쪽), 0010(위쪽), 0100(오른쪽), 1000(아래쪽)과 각각 비교
                // 1이면 벽이 있다는 의미 이므로 다음으로 넘김
                if ((c_wall & (1 << i)) > 0)
                    continue;
                // 0이면 벽이 없는 곳이므로 다음 탐색
                int nr = c_row + dir[i][0];
                int nc = c_col + dir[i][1];
                if (nr < 0 || nc < 0 || nr >= rowN || nc >= colN || visit[nr][nc])
                    continue;
                queue.offer(new int[]{nr, nc});
                visit[nr][nc] = true;
            }
        }
        resultMaxRoom = Math.max(resultMaxRoom, roomSize);
    }
}
