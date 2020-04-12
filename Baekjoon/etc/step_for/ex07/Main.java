package step_for.ex07;

import java.util.Scanner;
public class Main {
	private static int cnt = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		x = 1 <= x && x <= 12 ? x : 1;
		y = 1 <= y && y <= 31 ? y : 1;
		for (int i = 1; i <= x; i++)
			if (i == x)
				for (int j = 1; j <= y; j++)
					cnt++;
			else
				countMonth(i, y);
		cnt %= 7;
		switch (cnt) {
		case 0:
			System.out.println("SUN");
			break;
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		}
	}

	public static void countMonth(int month, int day) {
		switch (month) {
		case 1:
			for (int i = 1; i <= 31; i++)
				cnt++;
			break;
		case 2:
			for (int i = 1; i <= 28; i++)
				cnt++;
			break;
		case 3:
			for (int i = 1; i <= 31; i++)
				cnt++;
			break;
		case 4:
			for (int i = 1; i <= 30; i++)
				cnt++;
			break;
		case 5:
			for (int i = 1; i <= 31; i++)
				cnt++;
			break;
		case 6:
			for (int i = 1; i <= 30; i++)
				cnt++;
			break;
		case 7:
			for (int i = 1; i <= 31; i++)
				cnt++;
			break;
		case 8:
			for (int i = 1; i <= 31; i++)
				cnt++;
			break;
		case 9:
			for (int i = 1; i <= 30; i++)
				cnt++;
			break;
		case 10:
			for (int i = 1; i <= 31; i++)
				cnt++;
			break;
		case 11:
			for (int i = 1; i <= 30; i++)
				cnt++;
			break;
		}
	}
}
