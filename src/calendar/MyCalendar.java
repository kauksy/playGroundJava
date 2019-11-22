package calendar;

import java.util.*;

public class MyCalendar {

	public static int[] BASIC_MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final Map<String, Integer> firstDay;

	static {
		firstDay = new HashMap<String, Integer>();
		firstDay.put("SU", 1);
		firstDay.put("MO", 2);
		firstDay.put("TU", 3);
		firstDay.put("WE", 4);
		firstDay.put("TH", 5);
		firstDay.put("FR", 6);
		firstDay.put("SA", 7);
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
			return LEAP_MAX_DAYS[month - 1];
		}

		return BASIC_MAX_DAYS[month - 1];
	}
	
	public int getDay(int day) {
		for(String str : firstDay.keySet()){
			if(firstDay.get(str) == day){
				return day;
			}
		}
		return -1;
	}
}
