package calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("일    월    화    수     목     금    토");
		System.out.println("----------------------");
		System.out.println("1  2  3   4   5   6  7");
		System.out.println("8  9  10  11  12  13 14");
		System.out.println("15 16 17  18  19  20 21");
		System.out.println("22 23 24  25  26  27 28");

		// 숫자를 입력 받아 해당하는 달의 최대 일수를 출력하는 프로그램
		System.out.println("달을 입력하세요.");

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int day = 0;
		int[] _31days = { 1, 3, 5, 7, 8, 10, 12 };
		if (a == 2) {
			day = 28;
			System.out.println("2월은 윤달이면 29일, 그렇지 않으면 28일까지 있습니다.");
		} else {
			for (int i = 0; i < _31days.length; i++) {
				if (_31days[i] == a) {
					day = 31;
					System.out.println();
					System.out.printf("%d월은 %d일까지 있습니다.", a, day);
					break;
				}
			}
		}

		if (day == 0) {
			day = 30;
			System.out.println();
			System.out.printf("%d월은 %d일까지 있습니다.", a, day);
		}
	}
}
