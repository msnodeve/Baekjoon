import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution_1209_Sum {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/swea/d3/1209_Sum.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 입력
        int T = 10;
        int[][] list;
        for (int testcase = 1; testcase <= 10; testcase++) {
            // 입력
            int max = 0;
            int tempMax = 0;
            int testCase = Integer.parseInt(br.readLine());
            list = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                tempMax = 0;
                for (int j = 0; j < 100; j++) {
                    int getValue = Integer.parseInt(st.nextToken());
                    tempMax += getValue;
                    list[i][j] = getValue;
                }
                if(max < tempMax)
                    max = tempMax;
            }
            for (int i = 0; i < 100; i++) {
                tempMax = 0;
                for (int j = 0; j < 100; j++) {
                    int getValue = list[j][i];
                    tempMax += getValue;
                }
                if(max < tempMax)
                    max = tempMax;
            }
            tempMax = 0;
            for (int i = 0; i < 100; i++) {
                tempMax += list[i][i];
            }
            if(max < tempMax)
                max = tempMax;

            tempMax = 0;
            for (int i = 0; i < 100; i++) {
                tempMax += list[i][99-i];
            }
            if(max < tempMax)
                max = tempMax;

            System.out.println("#" + testCase + " " + max);
        }
    }
}
