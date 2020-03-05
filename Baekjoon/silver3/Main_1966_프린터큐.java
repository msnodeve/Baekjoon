package silver3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {
    static LinkedList<int[]> queue;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int result = 0;
            queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            // 처리
            while(true){
                int[] temp = {0, 0};
                int max = 0;
                for (int[] q : queue) {
                    if(max < q[1]){
                        temp = q;
                        max = q[1];
                    }
                }
                while(true){
                    if(queue.getFirst()[0] != temp[0]){
                        queue.offer(queue.poll());
                    }else{
                        break;
                    }
                }
                result++;
                if(queue.poll()[0] == M){
                    break;
                }
            }
            // 출력
            System.out.println(result);
        }
    }
}