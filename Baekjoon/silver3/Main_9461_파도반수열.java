package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_9461_파도반수열 {
    static int N;
    static long list[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        list = new long[101];
        list[1] = 1;
        list[2] = 1;
        list[3] = 1;
        for (int i = 4; i < list.length; i++) {
            list[i] = list[i-2] + list[i-3];
        }
        
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(list[N]);
        }
    }
}
