import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_10872 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 및 처리 및 출력
        System.out.println(factorial(Integer.parseInt(br.readLine())));
    }

    private static int factorial(int n) {
        if( n == 0 || n == 1){
            return 1;
        }
        return factorial(n-1) * n;
    }

}