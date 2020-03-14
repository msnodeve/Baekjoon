package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_1904_01타일 {
    static int N;
    static long list[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new long[1000001];
        list[1] = 1;
        list[2] = 2;
        for (int i = 3; i < list.length; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 15746;
        }

        System.out.println(list[N]);
    }
}
