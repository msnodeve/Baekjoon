package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N ; i++) {
            int divide = 2;
            double root = Math.sqrt(i);
            boolean primeNumberFlag = true;
            if(i == 1){
                primeNumberFlag = false;
            }
            while(root >= divide){
                if(i % divide == 0){
                    primeNumberFlag = false;
                    break;
                }
                divide++;
            }
            if(primeNumberFlag){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
