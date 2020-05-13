package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13459_구슬탈출 {
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    static int R, C;
    static char[][] map;
    static boolean[][][][] visit; // 빨간 구슬의 위치, 파란 구슬의 위치
    static Queue<Node> redBallList;
    static Queue<Node> blueBallList;
    static Node destination;
    static int ans;
    static boolean flag;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C][R][C];
        redBallList = new LinkedList<>();
        blueBallList = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    destination = new Node(i, j);
                } else if (map[i][j] == 'B') {
                    blueBallList.add(new Node(i, j));
                } else if (map[i][j] == 'R') {
                    redBallList.add(new Node(i, j));
                }
            }
        }

        solution();

        if (flag)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static void solution() {
        Node redLocation = redBallList.peek();
        Node blueLocation = blueBallList.peek();
        visit[redLocation.row][redLocation.col][blueLocation.row][blueLocation.col] = true;

        while (!redBallList.isEmpty()) {
            int size = redBallList.size();
            while(size-- > 0){
                redLocation = redBallList.poll();
                blueLocation = blueBallList.poll();
                int rr = redLocation.row;
                int rc = redLocation.col;
                int br = blueLocation.row;
                int bc = blueLocation.col;

                if(ans > 10)
                    break;

                if (rr == destination.row && rc == destination.col) {
                    flag = true;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nrr = rr + dir[i][0];
                    int nrc = rc + dir[i][1];
                    int nbr = br + dir[i][0];
                    int nbc = bc + dir[i][1];

                    while (true) {
                        if (map[nrr][nrc] == '#') {
                            nrr -= dir[i][0];
                            nrc -= dir[i][1];
                            break;
                        }
                        if (map[nrr][nrc] == 'O') {
                            break;
                        }
                        nrr += dir[i][0];
                        nrc += dir[i][1];
                    }
                    while (true) {
                        if (map[nbr][nbc] == '#') {
                            nbr -= dir[i][0];
                            nbc -= dir[i][1];
                            break;
                        }
                        if (map[nbr][nbc] == 'O') {
                            break;
                        }
                        nbr += dir[i][0];
                        nbc += dir[i][1];
                    }

                    if (nbr == destination.row && nbc == destination.col) {
                        continue;
                    }

                    if (nrr == nbr && nrc == nbc) {
                        switch (i) {
                            case 0:
                                if (rr < br) nbr++;
                                else nrr++;
                                break;
                            case 1:
                                if (rr < br) nrr--;
                                else nbr--;
                                break;
                            case 2:
                                if (rc < bc) nbc++;
                                else nrc++;
                                break;
                            case 3:
                                if (rc < bc) nrc--;
                                else nbc--;
                                break;
                        }
                    }

                    if (visit[nrr][nrc][nbr][nbc])
                        continue;
                    redBallList.offer(new Node(nrr, nrc));
                    blueBallList.offer(new Node(nbr, nbc));
                    visit[nrr][nrc][nbr][nbc] = true;
                }
            }
            if(flag)
                break;
            else
                ans++;
        }
    }
}