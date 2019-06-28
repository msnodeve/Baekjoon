// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int front = 0;
        int back = 0;
        
        for (int i = 0; i < A.length; i++){
            back += A[i];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < A.length; i++){
            front += A[i-1];
            back -= A[i-1];
            min = Math.min(min, Math.abs(front - back));
        }
        return min;
    }
}