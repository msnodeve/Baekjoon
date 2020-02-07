package step_for.ex10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(reader.readLine());
		int[] sum = new int[num];
		String strNum;
		for(int i=1; i<= num; i++){
			strNum = reader.readLine();
			writer.write(Integer.parseInt(strNum.split(" ")[0]) + Integer.parseInt(strNum.split(" ")[1])+"\n");
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}
