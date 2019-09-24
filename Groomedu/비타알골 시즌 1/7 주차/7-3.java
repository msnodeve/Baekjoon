import java.io.*;
class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int productCount;
	private static int maxHeight;
	private static int dp[][];
	
	public static void main(String[] args) throws Exception {
		userInput();
		System.out.println(solution());
	}
	
	public static void userInput() throws Exception {
		String input = br.readLine();
		productCount = Integer.parseInt(input.split(" ")[0]);
		maxHeight = Integer.parseInt(input.split(" ")[1])/10;
		dp = new int[11][1001];
	}
	
	public static int solution(){
		for(int i = 1; i <= productCount; i++){
			// 기저 사례 : maxHeight가 0, 1일 때
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		for(int i = 1 ; i <= maxHeight; i++){
			// 기저 사례 : productCount가 1일 때
			dp[1][i] = i;
		}
		
		for(int i = 2; i <= productCount; i++){
			for(int j = 2; j <= maxHeight; j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int z = 1; z <= j; z++){
					dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][z - 1], dp[i][j - z]));
				}
			}
		}	
		return dp[productCount][maxHeight];
	}
}