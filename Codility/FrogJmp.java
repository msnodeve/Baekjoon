// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {
        int totalD = Y-X;
        if(totalD % D == 0){
            return totalD / D;
        }else{
            return totalD / D + 1;
        }
    }
}