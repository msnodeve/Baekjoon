package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
    static int result;
    static int[] cost, calender;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            result = Integer.MAX_VALUE;
            cost = new int[4];
            calender = new int[13];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cost.length; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < calender.length; i++) {
                calender[i] = Integer.parseInt(st.nextToken());
            }

            // 처리
            dfs(1, 0);

            // 출력
            System.out.println("#" + testcase + " " + result);
        }
    }

    private static void dfs(int month, int money) {
        int addMoney = 0;

        // 12월을 만났다면
        if (month >= 13) {
            result = Math.min(result, money);
            return;
        }

        // 1년 짜리
        if (month == 1) {
            addMoney = cost[3];
            dfs(month+12, money+addMoney);
        }

        // 해당 날이 0이면
        if(calender[month] == 0){
            // 그냥 넘김
            dfs(month+1, money);
        }else{
            // 1일 권 이용할 경우
            addMoney = cost[0] * calender[month];
            dfs(month+1, money+addMoney);

            // 1달권을 이용할 경우
            addMoney = cost[1];
            dfs(month+1, money+addMoney);
        }

        // 3달짜리로 계산
        if(month + 3 <= 13){
            addMoney = cost[2];
            dfs(month+3, money + addMoney);
        }
    }
}
