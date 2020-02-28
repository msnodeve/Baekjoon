package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        // 처리
        Arrays.sort(tree);
        long max = tree[tree.length - 1];
        long min = 0;
        long mid = 0;

        while (max >= min) {
            mid = (max + min) >> 1;
            long sum = 0;
            long count = 0;
            for (int i = 0; i < N; i++) {
                count = tree[i] - mid;
                if(count > 0){
                    sum += count;
                }
            }

            if(sum >= M){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        System.out.println(max);
    }
}
