package silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10845_큐 {
    static LinkedList<Integer> queue;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!queue.isEmpty()){
                        result.append(queue.poll()+"\n");
                    }else{
                        result.append("-1\n");
                    }
                    break;
                case "size":
                    result.append(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        result.append("1\n");
                    }else{
                        result.append("0\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        result.append("-1\n");
                    }else{
                        result.append(queue.peekFirst()+"\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        result.append("-1\n");
                    }else{
                        result.append(queue.peekLast()+"\n");
                    }
                    break;
            }
        }
        System.out.println(result.toString());
    }
}
