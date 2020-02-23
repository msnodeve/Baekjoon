import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2588 {


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        System.out.println(num1 * (num2 % 10));
        System.out.println(num1 * ((num2 % 100) / 10));
        System.out.println(num1 * (num2 / 100));
        System.out.println(num1 * num2);
    }
}
