package calendar;

import java.util.Scanner;

public class CalendarExam {

	private static Scanner scan = new Scanner(System.in);
	private static MyCalendar myCalendar = new MyCalendar();
	private static final int WEEK = 7;
	private static final String SPACE = "   ";

	public static void main(String[] args) {

		int year = 2019;
		int month = 1;

		while (true) {
			System.out.println("년도를 입력해주세요. (EXIT: -1)");
			System.out.print("Year> ");
			year = scan.nextInt();

			if (year == -1) {
				break;
			}

			System.out.println("월을 입력해주세요.");
			System.out.print("Month> ");
			month = scan.nextInt();

			if (month > 12 || month < 1) {
				System.out.println("잘못된 월을 입력하셨습니다.");
				continue;
			}

			int firstDay = myCalendar.standardCalendar(year, month);
			myCalendar.calendarFrame(year, month);

			int maxDay = myCalendar.getMonthOfMaxDays(year, month);

			for (int i = 0; i < firstDay; i++) {
				System.out.printf(SPACE);
			}

			int nextWeek = WEEK - firstDay == 7 ? 0 : WEEK - firstDay;

			for (int i = 1; i <= maxDay; i++) {
				System.out.printf("%3d", i);
				if (i % 7 == nextWeek) {
					System.out.printf("\n");
				}
			}
			System.out.println();
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
