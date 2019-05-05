package op.ex08;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N,cnt=0;
		N = scan.nextInt();
		N = (3<= N) && (N<=50000) ? N : -1;
		while(true) {
			if(N%5==0) {
				System.out.println(N/5 + cnt);
				break;
			}else if(N<0) {
				System.out.println(-1);
				break;
			}
			N-=3;
			cnt++;
		}
	}
}