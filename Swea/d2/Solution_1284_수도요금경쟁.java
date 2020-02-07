package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution_1284_수도요금경쟁
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/swea/d2/1284_수도 요금 경쟁.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testcase = 1; testcase <= T; testcase++) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	
        	int P = Integer.parseInt(st.nextToken()); // A 사의 L 당 요금
        	int Q = Integer.parseInt(st.nextToken()); // B 사의 기본 요금
        	int R = Integer.parseInt(st.nextToken()); // B 사의 제한 L
        	int S = Integer.parseInt(st.nextToken()); // B 사의 제한요금 이상일 경우 L 당 요금
        	int W = Integer.parseInt(st.nextToken()); // 종민이가 사용한 L
        	
        	int A = P * W; // A 사를 사용했을 경우 요금
        	int B = R >= W ? Q : Q + (W - R) * S;
			int result = A < B ? A : B;
			System.out.println("#" + testcase + " " + result);
		}
    }
}
