package calendar;

import java.util.*;

public class MyCalendar {

	public static int[] BASIC_MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final Map<Integer, String> firstDay;

	static {
		firstDay = new HashMap<Integer, String>();
		firstDay.put(1, "SU");
		firstDay.put(2, "MO");
		firstDay.put(3, "TU");
		firstDay.put(4, "WE");
		firstDay.put(5, "TH");
		firstDay.put(6, "FR");
		firstDay.put(7, "SA");

	}

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
			return LEAP_MAX_DAYS[month];
		}

		return BASIC_MAX_DAYS[month];
	}

	public String getFirstDay(int day) {
		return (firstDay.get(day));
	}

	public int standardCalendar(int year, int month) {
		// 1970. 01. 01 THUR 를 기준으로 한다.
		int standardYear = 1970;
		int standardMonth = 1;
		int standardWeekday = 5;

		int count = 0;
		for (int i = standardYear; i < year; i++) {
			int distance = checkLeapYear(i) ? 366 : 365;
			count += distance;
		}

		for (int i = standardMonth; i < month; i++) {
			int distance = getMonthOfMaxDays(year, i);
			count += distance;
		}

		count = count - 1;

		int resultWeekday = (count + standardWeekday) % 7;
		return resultWeekday;
	}
}
