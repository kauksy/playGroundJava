package calendar;

import java.util.Scanner;

public class CalendarExam {

	private static Scanner scan = new Scanner(System.in);
	private static MyCalendar myCalendar = new MyCalendar();
	private static final int WEEK = 7;
	private static final String SPACE = "   ";

	public static void main(String[] args) {

		int year = -1;
		int month = -1;
		String day;

		while (true) {
			System.out.println("년도를 입력해주세요.");
			System.out.print("Year> ");
			year = scan.nextInt();

			System.out.println("월을 입력해주세요.");
			System.out.print("Month> ");
			month = scan.nextInt();

			System.out.println("첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
			System.out.print("WeekDay> ");
			day = scan.next();

			if (year == -1 || month == -1) {
				break;
			}

			int maxDay = myCalendar.getMonthOfMaxDays(year, month);
			myCalendar.calendarFrame(year, month);

			int firstDay = myCalendar.getFirstDay(day);

			for (int i = 0; i < firstDay; i++) {
				System.out.printf(SPACE);
			}

			int nextWeek = WEEK - firstDay;

			for (int i = 1; i <= maxDay; i++) {
				System.out.printf("%3d", i);
				if (i % 7 == nextWeek) {
					System.out.printf("\n");
				}
			}
			System.out.println();
		}
		System.out.println();

	}

}
