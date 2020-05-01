package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4366_정식이의은행업무 {
    static StringBuilder binTo2, binTo3;
    static StringBuilder tempBinTo2, tempBinTo3;
    static long result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            binTo2 = new StringBuilder();
            binTo3 = new StringBuilder();
            binTo2.append(br.readLine());
            binTo3.append(br.readLine());
            result = 0;

            top:
            for (int i = 0; i < binTo2.length(); i++) {
                for (char j = '0'; j < '2'; j++) {
                    tempBinTo2 = new StringBuilder(binTo2);
                    if (binTo2.charAt(i) != j) {
                        tempBinTo2.setCharAt(i, j);

                        for (int k = 0; k < binTo3.length(); k++) {
                            for (char l = '0'; l < '3'; l++) {
                                tempBinTo3 = new StringBuilder(binTo3);
                                if (binTo3.charAt(k) != l) {
                                    tempBinTo3.setCharAt(k, l);
                                    if (Long.parseLong(tempBinTo2.toString(), 2) == Long.parseLong(tempBinTo3.toString(), 3)) {
                                        result = Long.parseLong(tempBinTo2.toString(), 2);
                                        break top;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("#" + testcase + " " + result);
        }
    }
}
