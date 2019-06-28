// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        
        boolean [] check = new boolean[X];
        
        int cnt = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] <= X){
                if(!check[A[i]-1])
                    cnt++;
                check[A[i]-1] = true;
            }
            if(cnt==X) return i;
        }
        return -1;
    }
}