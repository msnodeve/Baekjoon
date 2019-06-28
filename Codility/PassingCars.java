// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int temp = 0;
        int result = 0;
        for(int i = 0 ; i<A.length;i ++){
            if(A[i]==0)
                temp++;
            else
                result += temp;
        }
        if (result > 1000000000 || result < 0)
            return -1;
        return result;
    }
}