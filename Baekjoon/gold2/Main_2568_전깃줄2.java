package gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.WriteAbortedException;
import java.util.*;

public class Main_2568_전깃줄2 {
    static class Wire implements Comparable<Wire> {
        int left, right;

        public Wire(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Wire o) {
            return Integer.compare(this.left, o.left);
        }
    }

    static Wire[] wires;
    static int N;
    static int[] LIS;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        wires = new Wire[N];
        LIS = new int[N];
        boolean[] visit = new boolean[500001];
        Wire[] trace = new Wire[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(left, right);
            visit[left] = true;
        }

        Arrays.sort(wires);

        int idx = 0;
        LIS[idx] = wires[0].right;
        trace[0] = new Wire(0, wires[0].left);
        for (int i = 1; i < N; i++) {
            if (LIS[idx] < wires[i].right) {
                LIS[++idx] = wires[i].right;
                trace[i] = new Wire(idx, wires[i].left);
            } else {
                int temp = binarySearch(0, idx, wires[i].right);
                LIS[temp - 1] = wires[i].right;
                trace[i] = new Wire(temp - 1, wires[i].left);
            }
        }

        System.out.println(N - (idx + 1));

        List<Integer> list = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (trace[i].left == idx) {
                list.add(trace[i].right);
                idx--;
            }
        }

        for (int l : list)
            visit[l] = false;

        for (int i = 0; i < 500001; i++) {
            if (visit[i])
                System.out.println(i);
        }
    }

    private static int binarySearch(int left, int right, int v) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (LIS[mid] >= v)
                right = mid;
            else
                left = mid + 1;
        }
        return right + 1;
    }
}
