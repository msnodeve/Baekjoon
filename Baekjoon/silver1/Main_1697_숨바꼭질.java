package silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Location {
    int loc;
    int cnt;

    public Location(int loc, int cnt) {
        this.loc = loc;
        this.cnt = cnt;
    }
}

public class Main_1697_숨바꼭질 {
    static int N, K;
    static boolean[] visit;
    static int result;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        bfs(N);

        System.out.println(result);
    }

    private static void bfs(int loc) {
        LinkedList<Location> queue = new LinkedList<>();
        queue.offer(new Location(loc, 0));
        visit[loc] = true;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            // 동생을 찾았다면
            if(location.loc == K){
                result= location.cnt;
                return;
            }

            loc = location.loc - 1;
            if(loc > -1 && loc < 100001 && !visit[loc]){
                queue.offer(new Location(loc, location.cnt+1));
                visit[loc] = true;
            }
            loc = location.loc + 1;
            if(loc > -1 && loc < 100001 && !visit[loc]){
                queue.offer(new Location(loc, location.cnt+1));
                visit[loc] = true;
            }
            loc = location.loc << 1;
            if(loc > -1 && loc < 100001 && !visit[loc]){
                queue.offer(new Location(loc, location.cnt+1));
                visit[loc] = true;
            }
        }
    }
}
