package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class Solution_1986_지그재그숫자
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/swea/d2/1986_지그재그 숫자.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			
			int result = 0;
			for (int i = 1; i <= N; i++) {
				result += i % 2 == 1 ? i : -i;
			}
			
			System.out.println("#" + testcase + " " + result);
		}
    }
}
