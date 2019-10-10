import java.io.*;
import java.util.*;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int testCase;
	private static String words;
	private static char[] mirrorWords;
	private static ArrayList<String> results;
	public static void main(String[] args) throws Exception {
		init();
		inputTestCase();
		solution();
	}
	private static void init(){
		results = new ArrayList();
		mirrorWords = new char[128];
		mirrorWords['b'] = 'd'; mirrorWords['d'] = 'b'; mirrorWords['i'] = 'i';
		mirrorWords['l'] = 'l'; mirrorWords['m'] = 'm'; mirrorWords['n'] = 'n';
		mirrorWords['o'] = 'o'; mirrorWords['p'] = 'q'; mirrorWords['q'] = 'p';
		mirrorWords['s'] = 'z'; mirrorWords['z'] = 's'; mirrorWords['u'] = 'u';
		mirrorWords['v'] = 'v'; mirrorWords['w'] = 'w'; mirrorWords['x'] = 'x';
	}
	private static void inputTestCase() throws Exception {
		testCase = Integer.parseInt(br.readLine());
	}
	private static void inputWords() throws Exception {
		words = br.readLine();
	}
	private static void solution() throws Exception {
		for(int i = 0; i < testCase; i++){
			inputWords();
			Boolean check = true;
			for(int j = 0; j <= words.length() / 2; j++){
				if(mirrorWords[words.charAt(j)] != words.charAt(words.length() - 1 - j)){
					check = false;
				}
			}
			if(check){
				results.add("Mirror");
			}else{
				results.add("Normal");
			}
		}
		for(String value : results){
			System.out.println(value);
		}
	}
}