package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] list = new int[K];
        for (int i = 0; i < K; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // 처리
        Arrays.sort(list);
        long max = list[list.length - 1];
        long min = 1;
        long mid = 0;

        while (max >= min) {
            mid = (max + min) >> 1;

            long count = 0;
            for (int i = 0; i < K; i++) {
                count += list[i] / mid;
            }

            if(count >= N){
                min = mid+1;
            }else{
                max = mid-1;
            }
        }

        System.out.println(max);
    }
}
