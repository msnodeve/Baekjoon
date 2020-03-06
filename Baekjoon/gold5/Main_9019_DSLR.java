package gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_9019_DSLR {
    static String[] command;
    static boolean[] visit;
    static int startNum, destinationNum;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            startNum = Integer.parseInt(st.nextToken());
            destinationNum = Integer.parseInt(st.nextToken());
            command = new String[10000];
            Arrays.fill(command,"");
            visit = new boolean[10000];

            bfs();
            System.out.println(command[destinationNum]);
        }
    }

    private static void bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(startNum);
        visit[startNum] = true;
        while(!queue.isEmpty()){
            int num = queue.poll();
            int D = (num * 2) % 10000;
            int S = num == 0 ? 9999: num-1;
            int L = (num%1000) * 10 + num/1000;
            int R = (num / 10) + (num % 10) * 1000;

            if(!visit[D]){
                queue.offer(D);
                visit[D] = true;
                command[D] = command[num]+"D";
            }
            if(!visit[S]){
                queue.offer(S);
                visit[S] = true;
                command[S] = command[num]+"S";
            }
            if(!visit[L]){
                queue.offer(L);
                visit[L] = true;
                command[L] = command[num]+"L";
            }
            if(!visit[R]){
                queue.offer(R);
                visit[R] = true;
                command[R] = command[num]+"R";
            }
        }
    }
}
