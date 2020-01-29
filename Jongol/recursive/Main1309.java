package jungol.recursive;

import java.util.Scanner;

public class Main1309 {
	public static long fac(int n) {
		if(n == 0) return 1;
		if(n != 1)
			System.out.println(n +"! = " + n + " * " + (n-1)+"!");
		else
			System.out.println(n +"! = " + n);
		return n * fac(n-1);		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		System.out.println(fac(num));
	}
}
