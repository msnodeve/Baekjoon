package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N + 1];
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(map[1]);
        } else {
            result[1] = map[1]; // 처음은 무조건 선택
            result[2] = map[1] + map[2]; // 2번째까지 선택한것
            // 3번째부터는 선택을 안하고, 하고를 저장해야함
            for (int i = 3; i <= N; i++) {
                // 이전과 지금값 선택, 그리고 그이전은 선택안한 그 전 결과값을 가져옴
                // 지금을 선택하고 이전을 선택안했을때, 그럼 그 이전의 결과 값을 가져옴
                result[i] = Math.max(map[i] + map[i - 1] + result[i - 3], map[i] + result[i - 2]);
            }

            System.out.println(result[N]);
        }
    }
}
