package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main_1759_암호만들기 {
    static StringBuilder sb = new StringBuilder();
    static char[] inputs;
    static char[] characters;
    static int L, C; // (3 ≤ L ≤ C ≤ 15)

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        characters = new char[L];
        inputs = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            inputs[i] = st.nextToken().charAt(0);
        }

        // 정렬
        Arrays.sort(inputs);
        // 확인
        // System.out.println(Arrays.toString(inputs));

        dfs(0, 0, 0 ,0);

        System.out.println(sb.toString());
    }

    private static void dfs(int cur, int cnt, int aCnt, int mCnt) {

        // cnt == L 의 개수만큼 뽑았다면
        if(cnt == L){
            // 모음이 1개 이상이며, 자음이 2개 이상일 때
            if(aCnt >= 1 && mCnt >= 2) {
                for(char character : characters){
                    sb.append(character);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = cur; i < C; i++) {
            characters[cnt] = inputs[i];
            switch (characters[cnt]){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    aCnt++;
                    break;
                default:
                    mCnt++;
                    break;
            }
            dfs(i+1, cnt+1, aCnt, mCnt);
            switch (characters[cnt]){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    aCnt--;
                    break;
                default:
                    mCnt--;
                    break;
            }
        }
    }
}
