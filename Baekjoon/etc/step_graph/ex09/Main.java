import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            List<Node> list = new ArrayList<>();
            int n = scanner.nextInt();
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(visited, false); // 방문한 노드는 1로 표기하자.
            int answer = 0;
            for (int k = 0; k < n + 1; k++) {
                list.add(new Node());
            }
            for (int j = 1; j <= n; j++) {
                int val = scanner.nextInt();
                list.get(j).child.add(val);
            }
            for (int j = 1; j <= n; j++) {
                // 이미 방문한 노드라면 bfs를 할 필요가 없다.
                if (!visited[j]) {
                    answer += bfs(list, visited, j);
                }
            }
            System.out.println(answer);
        }
    }

    public static int bfs(List<Node> list, boolean [] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int index = q.poll();
            for (int val : list.get(index).child) {
                if(!visited[val]) {
                    q.offer(val);
                }
                visited[val] = true;
            }
        }
        return 1;
    }

    static class Node {
        List<Integer> child = new ArrayList<>();
    }
}