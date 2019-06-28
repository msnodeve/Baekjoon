// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(int[] A) {
        if(A.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int result = 0;
        
        for(int i = 0; i < A.length; i++)
            map.put(A[i], A[i]);
        
        for(Integer key : map.keySet()){
            result++;
        }
        return result;
    }
}