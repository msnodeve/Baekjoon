// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Stack;

class Solution {
    public int solution(String S) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            
            char c = S.charAt(i);
            
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else{
                if(st.isEmpty())
                    return 0;
                    
                char stChar = st.pop();
                
                if(c == ')' && stChar != '(')
                    return 0;
                if(c == '}' && stChar != '{')
                    return 0;
                if(c == ']' && stChar != '[')
                    return 0;
            }
        }    
        if(!st.isEmpty())
            return 0;
        return 1;
    }
}
