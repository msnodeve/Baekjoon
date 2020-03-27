package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
    // 정점 수, 간선 수
    static int V, E;
    // 인접리스트
    static ArrayList<Integer>[] adj;
    // 방문 체크 배열
    static int[] visit;
    // 최종 체크
    static boolean flag;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        // testcase
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 정점의 수 입력
            V = Integer.parseInt(st.nextToken());
            // 간선의 수 입력
            E = Integer.parseInt(st.nextToken());
            flag = true;
            // 정점 1부터 시작으로 간주할 것임 0은 쓰지 않을 것
            adj = new ArrayList[V + 1];
            // 똑같이 정점 0은 체크안할 것
            visit = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }
            // 그래프 인접리스트로 입력
            for (int i = 1; i <= E; i++) {
                st = new StringTokenizer(br.readLine());
                // startV -> endV;
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // 두 정점간 연결
                adj[a].add(b);
                adj[b].add(a);
            }

            // 처리
            solution();

            // 출력
            System.out.println(flag ? "YES" : "NO");
        }
    }

    private static void solution() {
        // 정점들을 돌며
        for (int i = 1; i <= V; i++) {
            // 아직 방문하지 않았다면(0)
            if (visit[i] == 0) {
                // 1번째 색칠을 시작
                dfs(i, 1);
            }
        }

        // 1정점 부터 끝까지 돌며
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                // 지금 방문한 색칠공간이랑 인접리스트에있는 색칠 공간이랑 같다면 이건 이분그래프가 아님
                if (visit[i] == visit[adj[i].get(j)]) {
                    flag = false;
                    // 더 돌지말고 끝
                    return;
                }
            }
        }
    }

    private static void dfs(int curV, int flagColor) {
        // 현재 방문해서 색칠(제일처음은 1로 칠함)
        visit[curV] = flagColor;
        // 해당 간선 리스트만큼 돌며
        for (int i = 0; i < adj[curV].size(); i++) {
            // 아직 그 간선리스트에 정점이 방문하지 않았다면
            if (visit[adj[curV].get(i)] == 0) {
                // 지금 현재 색칠이 1이라면
                if (flagColor == 1) {
                    // 2로 칠하고 들어감
                    dfs(adj[curV].get(i), 2);
                }
                // 지금 현재 색칠이 2라면
                else {
                    // 1로 칠하고 들어감
                    dfs(adj[curV].get(i), 1);
                }
            }
        }
    }
}
