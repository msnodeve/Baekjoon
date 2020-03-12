package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_7701_염라대왕의이름정렬 {
    static int N;
    static ArrayList<String> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(br.readLine());
            }

            list.sort((o1, o2) -> {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            });
            System.out.println("#"+testcase);
            String temp = "";
            for (String s : list) {
                if (!temp.equals(s)) {
                    System.out.println(s);
                    temp = s;
                }
            }
        }
    }
}
