import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1347_미로만들기 {

    static StringBuilder sb;
    static int startRow, endRow, startCol, endCol;
    static boolean[][] visit;
    static int curDirection = 0;
    static int curRow, curCol;
    static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int writeLength = Integer.parseInt(br.readLine());
        char[] command = br.readLine().toCharArray();

        visit = new boolean[101][101];
        // 중간 지점 (50, 50)에서 시작
        curRow = curCol = 50;
        visit[curRow][curCol] = true;

        // 길이 만큼 반복
        for (int i = 0; i < writeLength; i++) {
            switch (command[i]) {
                case 'L': // 왼쪽으로 돌기
                    curDirection = (curDirection + 3) % 4;
                    break;
                case 'R': // 오른쪽으로 돌기
                    curDirection = (curDirection + 1) % 4;
                    break;
                case 'F': // 전진
                    curRow += dir[curDirection][0];
                    curCol += dir[curDirection][1];
                    visit[curRow][curCol] = true;
                    break;
            }
        }
        startRow = startCol = -1;
        endRow = endCol = -1;

        // startRow, endRow 구하기
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (startRow == -1 && visit[i][j]) {
                    startRow = i;
                }
                if (startRow != -1 && visit[i][j]) {
                    endRow = Math.max(endRow, i);
                }
            }
        }

        // startCol, endCol 구하기
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (startCol == -1 && visit[j][i]) {
                    startCol = i;
                }
                if (startCol != -1 && visit[j][i]) {
                    endCol = Math.max(endCol, i);
                }
            }
        }

        for (int i = startRow; i < endRow + 1; i++) {
            for (int j = startCol; j < endCol + 1; j++) {
                if (visit[i][j]) {
                    sb.append('.');
                } else {
                    sb.append('#');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
