package silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int min = 1;
        int max = home[N-1] - home[0];
        int result = 0;
        while (max >= min){
            int mid = (max + min) >> 1;
            int start = home[0];
            int cnt = 1;
            int dis = 0;

            for (int i = 1; i < N; i++) {
                dis = home[i] - start;
                if(mid <= dis){
                    cnt++;
                    start = home[i];
                }
            }

            if(cnt < C){
                max = mid - 1;
            }else{
                min = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
