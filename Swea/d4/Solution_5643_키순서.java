package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5643_키순서 {

    static int N, M;
    static List<Integer>[] list1, list2;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            list1 = new ArrayList[N + 1]; // 정방향 리스트
            list2 = new ArrayList[N + 1]; // 역방향

            // 리스트 배열 초기화
            for (int i = 0; i < N + 1; i++) {
                list1[i] = new ArrayList<>();
                list2[i] = new ArrayList<>();
            }

            // 리스트 입력 시작
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list1[x].add(y); // 정방향 리스트 입력
                list2[y].add(x); // 역방향 리스트 입력
            }

            // 정확히 내 순위를 알고 있는 사람인지 체크
            int result = 0;
            for (int i = 1; i < N + 1; i++) {
                // 정방향으로 돌렸을 경우 사람이 몇명인지 체크
                int l1 = solution(list1, i, new boolean[N + 1]);
                // 역방향으로 돌렸을 경우 사람이 몇명인지 체크
                int l2 = solution(list2, i, new boolean[N + 1]);

//                System.out.println(i + "번째 사람에서부터 큰사람의 수 -> " + (l1 - 1));
//                System.out.println(i + "번째 사람에서부터 작은 사람의 수 -> " + (l2 - 1));
//                System.out.println();

                // 나 한사람 빼고 개수 맞으면 정확한 위치를 알고 있음
                if (l1 + l2 - 1 == N) {
                    result++;
                }
            }
            System.out.println("#" + testcase + " " + result);
        }
    }

    private static int solution(List<Integer>[] list, int index, boolean[] visit) {
        int ret = 1;
        // 현재 사람의 위치 방문 체크
        visit[index] = true;
        // 현재 사람의 정방향이든 역방향이든 인원수만큼 dfs 돌림
        for (int i = 0; i < list[index].size(); i++) {
            if (!visit[list[index].get(i)])
                // 개수를 저장
                ret += solution(list, list[index].get(i), visit);
        }
        // 마지막 반환
        return ret;
    }
}
