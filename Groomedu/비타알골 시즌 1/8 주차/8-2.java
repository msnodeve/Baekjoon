import java.io.*;
class Main {
	private static int N;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		userInput();
		System.out.println(solution());
	}
	
	public static void userInput() throws Exception {
		N = Integer.parseInt(br.readLine());
	}
	
	public static int solution(){
		// 6이상의 각자리 수의 펙토리얼의 합은 9
		if(N >= 6){
			return 9;
		}
		// 5이하 일 경우 펙토리얼을 구해서 각자리 숫자가 10이하일때까지 돌림
		else{
			int factorial = 1;
			while(N > 0){
				factorial *= N--;
			}
			int result = 0;
			while(factorial > 9){
				result = 0;
				while(factorial > 0){
					result += factorial % 10;
					factorial /= 10;
				}
				factorial = result;
			}
			return factorial;
		}
	}
}