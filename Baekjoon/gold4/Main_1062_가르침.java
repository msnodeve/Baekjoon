package gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
    static int N, K, result;
    static String[] words;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        visit = new boolean[26];

        if (K < 5)
            System.out.println(0);
        else if (K == 26)
            // 알파벳의 개수는 26개라서 그냥 N 출력하면됨
            System.out.println(N);
        else {
            // a n t i c 를 제외(이미 고정되어서 들어오는 옴) 따라서 배웠다고 가정
            visit['a' -'a'] = true;
            visit['n' -'a'] = true;
            visit['t' -'a'] = true;
            visit['i' -'a'] = true;
            visit['c' -'a'] = true;
            K -= 5;

            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                words[i] = word.substring(4, word.length()-4);
            }

            solution(0, 0);
            System.out.println(result);
        }
    }

    private static void solution(int alpha, int cnt) {
        if(cnt == K) { // K개를 다 배운 경우
            int temp = 0; // 리스트들 중에서 배울수 있는 단어 체크
            for (int i = 0; i < N; i++) { // 리스트를 다돌려야함
                boolean flag = true; // 리스트 하나씩 돌리면서, 배울수 없다면 체크
                for (int j = 0; j < words[i].length(); j++) { // 해당 단어 길이만큼 돌리면서
                    if(!visit[words[i].charAt(j) - 'a']){ // 아직 배운게 아니라면 넘김
                        flag = false;
                        break;
                    }
                }
                // 배울수 있다는것을 확인했다면
                if(flag)
                    temp++;
            }
            result = Math.max(result, temp);
            return;
        }

        // 아직 K개를 배우지 않았다면 계속 검색
        for (int i = alpha; i < 26; i++) {
            if(!visit[i]){
                visit[i] = true;
                solution(i, cnt+1);
                visit[i] = false;
            }
        }
    }
}
