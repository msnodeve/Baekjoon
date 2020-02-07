package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
class Solution_2805_농작물_수확하기
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/swea/d3/2805_농작물 수확하기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testcase = 1; testcase <= T; testcase++) {
        	// 입력
        	int result = 0;
        	int N = Integer.parseInt(br.readLine());
        	int[][] map = new int[N][N];
        	
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = br.read()-48;
				}
				br.readLine();
			}
        	
        	// 처리
        	for (int i = 0; i < N/2 + 1; i++) {
				for (int j = N/2 - i; j < N/2 +1 + i; j++) {
					result += map[i][j];
				}
			}
        	for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N-1-i; j++) {
					result += map[i+N/2+1][j];
				}
			}
        	
        	// 출력
			System.out.println("#" + testcase + " " + result);
		}
    }
}
