package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class Solution_1798_범준이의제주도여행계획 {
    static class Point {
        String type;
        int idx;
        int playTime;
        int satis;
        Point nearH;

        public Point(String type, int idx) {
            this(type, idx, 0, 0);
        }

        public Point(String type, int idx, int playTime, int satis) {
            this.type = type;
            this.idx = idx;
            this.playTime = playTime;
            this.satis = satis;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "type='" + type + '\'' +
                    ", idx=" + idx +
                    ", playTime=" + playTime +
                    ", satis=" + satis +
                    '}';
        }
    }

    static StringBuilder output = new StringBuilder();
    static int N, M; // 지점의 개수, 휴가 기간
    static int[][] graph;
    static Point airPort;
    static List<Point> hotels;
    static List<Point> tourSpots;

    // 최대 만족도
    static int maxSatis;
    static List<Integer> maxSatisPath;

    // 탐색에 사용할 임시 경로
    static Stack<Integer> tempPath;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 그래프 구성
            graph = new int[N + 1][N + 1];
            for (int r = 1; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = r + 1; c < N + 1; c++) {
                    graph[r][c] = graph[c][r] = Integer.parseInt(st.nextToken());
                }
            }

            // 그래프 확인
            /*for(int[] row : graph)
                System.out.println(Arrays.toString(row));*/

            tourSpots = new ArrayList<>();
            hotels = new ArrayList<>();

            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                if (type.equals("H")) {
                    hotels.add(new Point(type, n));
                } else if (type.equals("A")) {
                    airPort = new Point(type, n);
                } else {
                    tourSpots.add(new Point(type, n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                }
            }

            // 지점 확인
            /*System.out.println(airPort);
            System.out.println(hotels);
            System.out.println(tourSpots);*/

            for (Point p : tourSpots) {
                int min = Integer.MAX_VALUE;
                for (Point h : hotels) {
                    if (graph[p.idx][h.idx] < min) {
                        min = graph[p.idx][h.idx];
                        p.nearH = h;
                    }
                }
            }

            // 가까운 호텔 확인
            /*for(Point p : tourSpots)
                System.out.println(p + " : " + p.nearH);*/

            maxSatis = Integer.MIN_VALUE;
            tempPath = new Stack<>();

            solve(0, airPort, 0, 0, new boolean[N + 1]);

            output.append("#").append(testcase).append(" ");
            if (maxSatis == Integer.MIN_VALUE) {
                output.append(0);
            } else {
                output.append(maxSatis).append(" ");
                for (int i : maxSatisPath) {
                    output.append(i).append(" ");
                }
            }
            output.append("\n");
        }
        System.out.println(output.toString());
    }

    static void solve(int day, Point start, int satis, int time, boolean[] visit) {
        if (day == M) {
            if (satis > maxSatis) {
                maxSatis = satis;
                // 최대 만족도에서의 경로 전달
                maxSatisPath = new ArrayList<>(tempPath);
            }
            return;
        }

        boolean canGoNext = false;
        for (Point point : tourSpots) {
            if (!visit[point.idx]) {
                int tempTime = time + graph[start.idx][point.idx] + point.playTime;
                if (day == M - 1) {
                    tempTime += graph[point.idx][airPort.idx];
                } else {
                    tempTime += graph[point.idx][point.nearH.idx];
                }

                if (tempTime > 540) {
                    continue;
                }
                canGoNext = true;
                visit[point.idx] = true;
                tempPath.push(point.idx);
                solve(day, point, satis + point.satis, time + graph[start.idx][point.idx] + point.playTime, visit);
                tempPath.pop();
                visit[point.idx] = false;
            }
        }

        if (!canGoNext) {
            if (day == M - 1) {
                tempPath.push(airPort.idx);
                solve(day + 1, airPort, satis, 0, visit);
                tempPath.pop();
            } else {
                for (Point hotel : hotels) {
                    if (time + graph[start.idx][hotel.idx] < 540) {
                        tempPath.push(hotel.idx);
                        solve(day + 1, hotel, satis, 0, visit);
                        tempPath.pop();
                    }
                }
            }
        }
    }
}
