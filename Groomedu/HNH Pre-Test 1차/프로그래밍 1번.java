import java.io.*;
import java.util.*;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int cardNum;
	private static int maxCount;
	private static HashMap<String, Integer> words;
	
	private static String result1;
	private static int result2;
	private static int result3;
	public static void main(String[] args) throws Exception {
		userInput();
		kindsCheck();
		checkAllCards();
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
	
	private static void userInput() throws Exception {
		maxCount = 1;
		words = new HashMap();
		cardNum = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < input.length; i++){
			if(words.get(input[i]) != null){
				words.put(input[i], words.get(input[i])+1);
				maxCount = Math.max(maxCount, words.get(input[i]));
			}else{
				words.put(input[i], 1);
			}
		}
	}
	private static void kindsCheck(){
		int countFlag = 0;
		for(String key : words.keySet()){
			if(maxCount > words.get(key)){
				countFlag++;
			}
			if(countFlag >= 2){
				result1 = "N";
				return;
			}
		}
		result1 = "Y";
	}
	private static void checkAllCards(){
		int kindCardNum = 0;
		int rst = 0;
		for(String key : words.keySet()){
			kindCardNum++;
			rst += words.get(key);
		}
		if(result1 == "Y"){
			result2 =  kindCardNum * maxCount;
		}else{
			result2 = rst;
		}
		result3 = kindCardNum;
	}
}