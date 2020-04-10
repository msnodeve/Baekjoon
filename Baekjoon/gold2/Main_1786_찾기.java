package gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1786_찾기 {

    static StringBuilder sb;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        sb = new StringBuilder();
        KMP(br.readLine(), br.readLine());
        System.out.println(result);
        System.out.println(sb.toString());
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

    static void KMP(String origin, String pattern) {
        int[] pi = getPi(pattern);
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if(origin.charAt(i) == pattern.charAt(j)){
                if(j == pattern.length()-1) {
                    result++;
                    sb.append(i - pattern.length() + 2).append(" ");
                    j = pi[j];
                }
                else{
                    j++;
                }
            }
        }
    }
}
