package gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1525_퍼즐 {

    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hashMap = new HashMap<>();
        int lineNum = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0){
                    num = 9;
                }
                lineNum = lineNum * 10 + num;
            }
        }
        hashMap.put(lineNum, 0);
        System.out.println(bfs(lineNum));
    }

    private static int bfs(int lineNum) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(lineNum);
        while(!queue.isEmpty()){
            int nowNum = queue.poll();
            String nowLineNum = String.valueOf(nowNum);
            int zero = nowLineNum.indexOf("9");
            int x = zero / 3; // 행
            int y = zero % 3; // 열
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int swapZeroIndex = nx * 3 + ny;
                if(nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    StringBuilder nextLineNum = new StringBuilder(nowLineNum);
                    char tempChar = nextLineNum.charAt(swapZeroIndex);
                    nextLineNum.setCharAt(swapZeroIndex, '9');
                    nextLineNum.setCharAt(zero, tempChar);
                    int nextNum = Integer.parseInt(nextLineNum.toString());
                    if(!hashMap.containsKey(nextNum)){
                        hashMap.put(nextNum, hashMap.get(nowNum)+1);
                        queue.offer(nextNum);
                    }
                }
            }
        }
        return hashMap.getOrDefault(123456789, -1);
    }
}
