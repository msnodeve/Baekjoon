package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
    static int N, M, C, result;
    static boolean[][] visit; // 방문표시할 것
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visit = new boolean[N][N];
            result = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            // 처리

            // 첫번째 꿀벌을 시작으로..
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    // 방문 처리 및 M 만큼 뽑은 배열
                    int[] firstArray = new int[M];
                    for (int k = 0; k < M; k++) {
                        firstArray[k] = map[i][j + k];
                        visit[i][j + k] = true;
                    }
                    // findValue() 함수를 통해 SubSet 으로 C와 같거나 작을때, 제곱 구함
                    int tempValue = findValue(firstArray);

                    // 2번째 벌이 잡을 꿀들을 돌림
                    for (int i1 = 0; i1 < N; i1++) {
                        for (int j1 = 0; j1 < N - M + 1; j1++) {
                            // 첫 번째 꿀벌이 방문하지 않았다면, 2번째 꿀벌의 꿀들을 배열로 뽑음
                            if(!visit[i1][j1]){
                                for (int k = 0; k < M; k++) {
                                    firstArray[k] = map[i1][j1 + k];
                                }
                                // 2번째 꿀벌의 SubSet 으로 제곱 구함
                                int tempSecond =findValue(firstArray);
                                // 1번째 꿀벌과 합함
                                tempValue += tempSecond;
                                // 값이 커질때마다 넣고
                                result = Math.max(result, tempValue);
                                // 일단 다음을 검사하기위해 두번째 놈을 다시 빼줌
                                tempValue -= tempSecond;
                            }
                        }
                    }
                }
            }

            // 출력
            System.out.println("#" + testcase + " " + result);
        }
    }

    private static int findValue(int[] arr) {
        int result = 0;
        for (int i = 0, size = 1 << arr.length; i < size; i++) {
            int tempR = 0;
            int temp = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((i & 1 << j) != 0) {
                    temp += arr[j];
                    if (temp <= C) {
                        tempR += Math.pow(arr[j], 2);
                    }
                }
            }
            result = Math.max(tempR, result);
        }
        return result;
    }
}
