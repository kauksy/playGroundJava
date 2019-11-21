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
			System.out.println("년도를 입력해주세요. (EXIT: -1)");
			System.out.print("Year> ");
			year = scan.nextInt();

			if (year == -1) {
				break;
			}

			checkThisYearInfo();

			// 1. 입력받은 연도 기준으로 평년, 윤년의 값을 Count한다.
			// 1-1. 2000년 전후 기준으로 나뉘어야한다?..
			System.out.println("월을 입력해주세요.");
			System.out.print("Month> ");
			month = scan.nextInt();

			if (month > 12 || month < 1) {
				System.out.println("잘못된 월을 입력하셨습니다.");
				continue;
			}

			// 1.
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
			System.out.print("WeekDay> ");
			day = scan.next();

			int maxDay = myCalendar.getMonthOfMaxDays(year, month);
			myCalendar.calendarFrame(year, month);

			int firstDay = myCalendar.getFirstDay(day);

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

	private static void checkThisYearInfo() {
		int todayIs = myCalendar.todayIs();
		int thisMonth = myCalendar.findThisMonth(todayIs);
		int thisDay = myCalendar.findThisDay();

	}

}
