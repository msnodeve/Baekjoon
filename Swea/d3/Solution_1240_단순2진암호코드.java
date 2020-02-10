import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution_1240_단순2진암호코드 {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/swea/d3/1240_단순 2진 암호코드.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 초기 데이터 입력
        init();

        // 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        int N, M;
        int[][] list;

        for (int testcase = 1; testcase <= T; testcase++) {
            // 입력
            int result = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new int[N][M];
            int[] checkPassWord = new int[8];
            int cpIndex = 0;
            for (int i = 0; i < N; i++) {
                String[] temp = br.readLine().split("");
                for (int j = 0; j < M; j++) {
                    list[i][j] = Integer.parseInt(temp[j]);
                }
            }
            boolean flag = false;
            int index = 0;

            // 처리
            for (int i = 0; i < N; i++) {
                cpIndex = 0;
                for (int j = M-1; j > -1; j--) {
                    if(list[i][j] == 1) {
                        flag = true;
                        index = j;
                        N = i;
                        break;
                    }
                }
                if(flag) {
                    for (int j = 7; j > -1; j--) {
                        String password = "";
                        for (int k = index - (j + 1) * 7 + 1; k < index - (j + 1) * 7 + 8; k++) {
                            password += list[i][k];
                        }
                        if (map.containsKey(password)) {
                            checkPassWord[cpIndex++] = map.get(password);
                        } else {
                            break;
                        }
                    }
                }
            }

            if(((checkPassWord[0] + checkPassWord[2] + checkPassWord[4] + checkPassWord[6]) * 3 + checkPassWord[1] + checkPassWord[3]+checkPassWord[5]+checkPassWord[7]) % 10 == 0){
                for (int i: checkPassWord) {
                    result += i;
                }
                System.out.println("#" + testcase + " " + result);
            }else{
                System.out.println("#" + testcase + " " + 0);
            }

        }
    }

    private static void init() {
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);
    }
}
