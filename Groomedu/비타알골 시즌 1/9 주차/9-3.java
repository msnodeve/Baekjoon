import java.io.*;
class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 현재 위치에서부터 N 미터 떨어진 곳
	// 장현이는 정확히 M마리를 잡고자 함
	private static int N, M;
	// 모여있는 물고기의 수
	private static int[] F;
	
	public static void main(String[] args) throws Exception {
		userInput();
		System.out.print(solution());
	}
	private static int solution(){
		int f = 0, e = 0, sum = 0, result = 0;
		
		while(f < N){
			// 끝이 길이보다 작고, 합이 원하는 M 보다 작을경우
			// sum 에 수만큼 더함
			if(e < N && sum < M){
				sum += F[e++];
			}
			// 그렇지 않은 경우
			// 앞에있는 것을 빼고 다음 칸으로 늘림
			else{
				sum -= F[f++];
			}
			// 합이 원하는 경우가 맞을 경우
			if(sum == M){
				result++;
			}
		}
		return result;
	}
	private static void userInput() throws Exception {
		String[] inputNM = br.readLine().split(" ");
		N = Integer.parseInt(inputNM[0]);
		M = Integer.parseInt(inputNM[1]);
		
		F = new int[N];
		String[] inputF = br.readLine().split(" ");
		for(int i = 0; i<N; i++){
			F[i] = Integer.parseInt(inputF[i]);
		}
	}
}