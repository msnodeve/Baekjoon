// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if(A.length==0 || A.length==1){
            return 0;
        }else{
            Arrays.sort(A);
            int gap = A[1] - A[0];
            for(int i = 0; i < A.length-1; i++){
                if(A[i+1] - A[i] == gap){
                    continue;
                }else{
                    return 0;
                }
            }
            return 1;
        }
    }
}