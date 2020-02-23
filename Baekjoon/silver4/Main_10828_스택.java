package silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {
    static Stack<Integer> stack;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num;
            switch (command){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.isEmpty()){
                        result.append(stack.pop()+"\n");
                    }else{
                        result.append("-1\n");
                    }
                    break;
                case "size":
                    result.append(stack.size() + "\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        result.append("1\n");
                    }else{
                        result.append("0\n");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        result.append("-1\n");
                    }else{
                        result.append(stack.peek()+"\n");
                    }
                    break;
            }
        }
        System.out.println(result.toString());
    }
}
