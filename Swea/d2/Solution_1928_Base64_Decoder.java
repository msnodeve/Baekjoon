package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.HashMap;

class Solution_1928_Base64_Decoder {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d2/1928_Base64 Decoder.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<Character, Integer> encodeData = new HashMap<>();
		encodeData.put('+', 62);
		encodeData.put('/', 63);

		char inputData = 'A';
		for (int i = 0; i < 26; i++) {
			encodeData.put(inputData++, i);
		}
		inputData = 'a';
		for (int i = 26; i < 52; i++) {
			encodeData.put(inputData++, i);
		}
		inputData = '0';
		for (int i = 52; i < 62; i++) {
			encodeData.put(inputData++, i);
		}

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase < T + 1; testCase++) {
			String result = "";

			String[] inputs = br.readLine().split("");
			for (int i = 0; i < inputs.length / 4; i++) {
				String temp = "";
				for (int j = i * 4; j < i * 4 + 4; j++) {
					temp += String.format("%6s", Integer.toBinaryString(encodeData.get(inputs[j].charAt(0))))
							.replace(' ', '0');
				}
				for (int j = 0; j < 3; j++) {
					String divInputs = temp.substring(j * 8, j * 8 + 8);
					result += (char)Integer.parseInt(divInputs, 2);
				}
			}
			
			System.out.println("#" + testCase + " " + result);
		}
	}
}