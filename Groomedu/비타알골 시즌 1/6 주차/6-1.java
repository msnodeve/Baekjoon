import java.io.*;

// 1-5 = 120, 1
// 6-10 = 362880, 2
// 11-15 = 13076743680, 3
// 16-20 = ..., 4
// 21-25 = ..., 6
// 26-30 = ..., 7

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int user = Integer.parseInt(input);
		int count = 0;
		while(user >= 5){
			user = user / 5;
			count = count + user; 
		}
		System.out.println(count);
	}
}