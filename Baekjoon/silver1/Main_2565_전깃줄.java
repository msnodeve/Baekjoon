package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2565_전깃줄 {
    static int[][] list;
    static int[] LIS;
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());

        list = new int[N][2];
        LIS = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 리스트 확인
        /*for (int[] l : list)
            System.out.println(Arrays.toString(l));*/



        // 최장 증가 수열 구하기
        for (int i = 0; i < N; i++) {
            LIS[i] = 1; // 자기 위치를 1로
            for (int j = 0; j < i; j++) {
                if(list[j][0] < list[i][0] && list[j][1] < list[i][1] && LIS[i] < LIS[j] + 1){
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        // 최대값 뽑아내기
        System.out.println(N - Arrays.stream(LIS).max().getAsInt());
    }
}
