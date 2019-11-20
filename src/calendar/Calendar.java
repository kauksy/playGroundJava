package calendar;

import java.util.Scanner;

/**
 * 가상의 달력찍기
 */
public class Calendar {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print(CalendarFactory.PROMPT);
			int month = scan.nextInt();
			if (month == -1) {
				break;
			}

			int calendar = CalendarFactory.getMaxDaysOfMonth(month);

			if (calendar == 28) {
				CalendarFactory.print_28Calendar();
			}

			if (calendar == 30) {
				CalendarFactory.print_30Calendar();
			}

			if (calendar == 31) {
				CalendarFactory.print_31Calendar();
			}
		}
		
		System.out.println("Bye~");
	}

}
