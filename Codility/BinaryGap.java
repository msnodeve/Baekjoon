// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
    public int solution(int N) {
        int max = 0;
        int cntTemp = 0;
        boolean fNum_1 = false;
        String[] biNum = Integer.toBinaryString(N).split("");
        for(int i=0;i<biNum.length;i++) {
            if(biNum[i].equals("1")){
                cntTemp = 0;
                for(int j=i+1; j < biNum.length ; j++){
                    if(biNum[j].equals("0")){
                        cntTemp++;
                        if(cntTemp==biNum.length-i-1){
                            cntTemp = 0;
                            break;
                        }
                    }else if(biNum[j].equals("1")){
                        break;
                    }
                }
                if(max < cntTemp){
                    max = cntTemp;
                }
            }
        }
        return max;
    }
}