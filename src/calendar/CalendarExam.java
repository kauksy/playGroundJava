package calendar;

import java.util.Scanner;
import java.util.TimerTask;

public class CalendarExam {

	private static Scanner scan = new Scanner(System.in);
	private static MyCalendar myCalendar = new MyCalendar();
	private static CalendarInformation ci = new CalendarInformation();

	private static final int WEEK = 7;
	private static final String SPACE = "   ";

	public static void main(String[] args) {

		int year = -1;
		int month = -1;

		// 기준 값 구하기: 올해 1월 1일은 무슨 요일인지 구한다.
		int standardYoil = ci.getStandardYearInfo();
		if (standardYoil == -1) {
			System.out.println("연산에 버그가 있습니다.");
		}
		standardYoil = myCalendar.getDay(standardYoil);
		System.out.println("standardYoil: " + standardYoil);

		while (true) {
			System.out.println("년도를 입력해주세요. (EXIT: -1)");
			System.out.print("Year> ");
			year = scan.nextInt();

			if (year == -1) {
				break;
			}

			// 사용자 입력 1월 1일의 요일
			int inputStandardYoil = ci.getInputStandardYearInfo(year, standardYoil);
			System.out.println("inputStandardYoil: " + inputStandardYoil);

			System.out.println("월을 입력해주세요.");
			System.out.print("Month> ");
			month = scan.nextInt();

			if (month > 12 || month < 1) {
				System.out.println("잘못된 월을 입력하셨습니다.");
				continue;
			}
			
			

			int maxDay = myCalendar.getMonthOfMaxDays(year, month);
			myCalendar.calendarFrame(year, month);

			int inputDistance = ci.getIputFirstDayOfMonth(month, year);
			int firstDay = ci.getYoil(inputStandardYoil, inputDistance);

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
