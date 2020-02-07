package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Solution_9317_석찬이의_받아쓰기
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/swea/d3/9317_석찬이의 받아쓰기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testcase = 1; testcase <= T; testcase++) {
        	int result = 0;
        	
        	int N = Integer.parseInt(br.readLine());
        	String correctLine = br.readLine();
        	String inputLine = br.readLine();
        	
        	for (int i = 0; i < N; i++) {
				if(correctLine.charAt(i) == inputLine.charAt(i)) {
					result++;
				}
			}
			
			System.out.println("#" + testcase + " " + result);
		}
    }
}
