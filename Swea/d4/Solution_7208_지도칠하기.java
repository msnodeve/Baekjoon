package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7208_지도칠하기 {
    static boolean[][] map;
    static int[] colors;
    static int N, result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            map = new boolean[N][N];
            colors = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { // 각 나라가 칠해져 있는 색 저장
                colors[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if (st.nextToken().charAt(0) == '1')
                        map[i][j] = true;
                }
            }

            // 맵 확인
            /*for(boolean[] row : map){
                System.out.println(Arrays.toString(row));
            }*/

            solution(0, 0);

            System.out.println("#" + testcase + " " + result);
        }
    }

    private static void solution(int idx, int cnt) {
        if (idx == N) { // 각나라들을 다 뽑아 봤다면
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 인접 국가이며, 그 나라끼리 색이 같다면 X
                    if(map[i][j] && colors[i] == colors[j]){
                        flag = false;
                    }
                }
            }
            if(flag)
                result = Math.min(cnt, result);
            return;
        }

        // 4가지의 색상을 넣어볼 예정
        for (int i = 1; i <= 4; i++) {
            if (colors[idx] == i) // 그나라가 해당 색을 가지고 있다면
                solution(idx + 1, cnt); // 변경 회수를 그대로 들고가며, 다음 나라를 검색
            else{ // 해당 색이 아니라면
                int tempColor = colors[idx];
                colors[idx] = i; // 바꿔치기
                solution(idx+1, cnt+1);
                colors[idx] = tempColor; // 바꿔치기 하기전으로 변경
            }
        }
    }
}
