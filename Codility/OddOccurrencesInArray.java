// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp=0;
        for(int i = 0 ; i<A.length; i++){
            for(int j = i ; j<A.length; j++){
                if(map.get(A[i]) == null){
                    map.put(A[i],A[i]);
                    break;
                }else{
                    map.remove(A[i]);
                    break;
                }
            }
        }
        
        for(Integer key : map.keySet()){
            temp = map.get(key);
        }
        return temp;
    }
}