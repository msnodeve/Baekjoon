// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        if(A[A.length-1] < 0)
            return A[A.length-1] * A[A.length-2] * A[A.length-3];
        if(A[A.length-2] < 0 || A[A.length-3] < 0)
            return A[A.length-1] * A[0] * A[1];
        
        int temp1 = A[A.length-1] * A[A.length-2] * A[A.length-3];
        int temp2 = A[A.length-1] * A[0] * A[1];
        return temp1 > temp2 ? temp1 : temp2;
    }
}