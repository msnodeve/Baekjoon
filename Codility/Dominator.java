// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;

class Solution {
    public int solution(int[] A) {
        
        HashMap <Integer, Integer> map = new HashMap<>();
        int result = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < A.length; i++){
            int cnt = (map.get(A[i])==null) ? 1 : map.get(A[i]) + 1;
            map.put(A[i], cnt);
            if(cnt == max){
                result = -1;
                continue;
            }
            if(cnt > max){
                max = cnt;
                result = i;
            }
        }
        if(max > A.length / 2)
            return result;
        
        return -1;
    }
}