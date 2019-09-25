import java.io.*;
import java.util.*;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int resource;
	private static int[] processNum;
	public static void main(String[] args) throws Exception {
		userInput();
		System.out.println(solution());
	}
	public static int solution(){
		int[] dp = new int[resource];
		for(int i = 0; i < resource; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(processNum[j] < processNum[i]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		Arrays.sort(dp);
		return resource - dp[dp.length - 1];
	}
	public static void userInput() throws Exception {
		resource = Integer.parseInt(br.readLine().split(" ")[0]);
		String[] inputProcessNum = br.readLine().split(" ");
		processNum = new int[resource];
		for(int i = 0; i < inputProcessNum.length; i++){
			processNum[i] = Integer.parseInt(inputProcessNum[i]);
		}
	}
}