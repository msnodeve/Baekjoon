package baekjoon.bronze3;

import java.util.Scanner;

class Main_10952 {
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			int index = 0;
			int max = 0;
			int[] w = new int[3];
			w[0] = scan.nextInt();
			w[1] = scan.nextInt();
			w[2] = scan.nextInt();
			if(w[0] == 0 && w[1] == 0 && w[2] == 0)
				break;
			
			for (int i = 0; i < 3; i++) {
				if(max < w[i]) {
					max = w[i];
					index = i;
				}
			}
			
			int a = 0;
			int b = 0;
			
			for (int i = 0; i < 3; i++) {
				if(i == index) {
					b = (int) Math.pow(w[i], 2);
				}else {
					a += Math.pow(w[i], 2);
				}
			}
			
			System.out.println(a == b ? "right" : "wrong");
		}
	}
}
