package calendar;

public class MyCalendar {

	public static int[] BASIC_MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public void calendarFrame(int year, int month) {
		System.out.printf(" [ %4d년 %3d월 ]\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("------------------------");

	}

	public boolean checkLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}
		return false;
	}

	public int getMonthOfMaxDays(int year, int month) {
		boolean checkLeapYear = checkLeapYear(year);

		if (checkLeapYear) {
			return LEAP_MAX_DAYS[month - 1];
		}
		
		return BASIC_MAX_DAYS[month - 1];
	}
}
