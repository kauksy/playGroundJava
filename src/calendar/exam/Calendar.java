package calendar.exam;

public class Calendar {

	public static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}
		return MAX_DAYS[month];
	}

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		return false;
	}

	public void printCalendar(int year, int month) {

		System.out.printf("<< %4d년  %3d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------------");

		// get Weekday automaically
		int weekday = getWeekday(year, month, 1);
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		count++;
		// print second line
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
	}

	private int getWeekday(int year, int month, int day) {
		// 1월 1일: 일요일 > 기준날짜의 요일을 알면 1월 N일의 요일을 알수 있다.
		// 컴퓨터에 입력 되어 있는 달력은 1970년 1월 1일 부터 시작된다.
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970.01.01: Thursday

		// 연도는 윤년:366, 일반: 365
		int count = 0;
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		count += day - 1;

		int weekday = (count + STANDARD_WEEKDAY) % 7;

		return weekday;
	}
}
