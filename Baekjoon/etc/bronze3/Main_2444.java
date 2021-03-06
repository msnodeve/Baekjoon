import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Main_2444 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 및 처리 및 출력
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N-1; i++) {
            for (int j = i; j < N -1; j++) {
                System.out.printf(" ");
            }
            for (int j = 0; j < 2* i + 1; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i * 2 +1; j < 2 * N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}