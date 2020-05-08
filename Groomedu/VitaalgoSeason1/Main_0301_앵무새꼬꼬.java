package VitaalgoSeason1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_0301_앵무새꼬꼬 {

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/etc/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int testcase = 1; testcase <= T; testcase++) {
            String line = br.readLine();
            sb.append(getString(line) + '\n');
        }
        System.out.println(sb.toString());
    }

    private static String getString(String line) {
        StringBuilder result = new StringBuilder();
        for (char str : line.toCharArray()) {
            switch (str){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    result.append(str);
                    break;
            }
        }
        if(result.length() == 0)
            return "???";
        return result.toString();
    }
}
