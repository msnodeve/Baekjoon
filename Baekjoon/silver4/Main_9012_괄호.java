package silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9012_괄호 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <=T ; testcase++) {
            String line = br.readLine();

            // 처리
            boolean flag = false;
            Stack<Character> stack = new Stack<>();
            for (char l : line.toCharArray()) {
                switch (l){
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if(!stack.isEmpty()){
                            l = stack.peek();
                            if(l == '('){
                                stack.pop();
                            }else{
                                flag = true;
                            }
                        }else{
                            flag = true;
                        }
                        break;
                }
            }
            if(!stack.isEmpty()){
                flag = true;
            }
            if(flag)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
