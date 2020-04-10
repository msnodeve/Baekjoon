package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_16916_부분문자열 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(KMP(br.readLine(), br.readLine()));
    }

    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static int KMP(String origin, String pattern) {
        int[] pi = getPi(pattern);
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return 1;
                } else {
                    j++;
                }
            }
        }
        return 0;
    }
}
