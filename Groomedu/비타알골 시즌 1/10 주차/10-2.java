import java.io.*;
class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int ratNum, resultA = 0, resultB = 0;
	private static int[] ratLocA, ratLocB;
	private static int[] cntA, cntB;
	public static void main(String[] args) throws Exception {
		solution();
	}
	
	private static void solution() throws Exception {
		cntA = new int[100005];
		cntB = new int[100005];
		ratNum = Integer.parseInt(br.readLine());
		ratLocA = new int[ratNum];
		ratLocB = new int[ratNum];
		String[] inputRatLocA = br.readLine().split(" ");
		String[] inputRatLocB = br.readLine().split(" ");
		for(int i = 0; i < ratNum; i++){
			ratLocA[i] = Integer.parseInt(inputRatLocA[i]);
			ratLocB[i] = Integer.parseInt(inputRatLocB[i]);
			for(int j = 0; j < 5; j++){
				cntA[ratLocA[i] + j]++;
				cntB[ratLocB[i] + j]++;
			}
		}
		int maxA = 0, maxB = 0;
		for(int i = 0; i < 100005; i++){
			if(resultA < cntA[i]){
				maxA = i;
				resultA = cntA[i];
			}
			if(resultB < cntB[i]){
				maxB = i;
				resultB = cntB[i];
			}
		}
		System.out.println((maxA - 2) + " "+ (maxB - 2));
		if(maxA > maxB){
			System.out.print("good");
		}else{
			System.out.print("bad");
		}
	}
}