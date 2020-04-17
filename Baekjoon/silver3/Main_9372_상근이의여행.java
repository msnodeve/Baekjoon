package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9372_상근이의여행 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = stringToInteger(st.nextToken());
            int E = stringToInteger(st.nextToken());
            for (int i = 0; i < E; i++) {
                br.readLine();
            }
            System.out.println(V-1);
        }
    }

    static int stringToInteger(String str){
        return Integer.parseInt(str);
    }
}
