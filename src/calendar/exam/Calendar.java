package calendar.exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 검색은 대부분 해시테이블을 씀! 해시테이블, 해시맵 = 검색
	// 생성자 호출할 때 초기화 되도록 한다.
	private HashMap<Date, String> planMap;

	public Calendar() {
		// 키: 날짜, 값: 일정(계획)
		planMap = new HashMap<Date, String>();
	}

	/**
	 * 
	 * @param date
	 *            ex: "2019-12-06"
	 * @param plan
	 */
	public void registerPlan(String strdate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
		planMap.put(date, plan);
	}

	public String searchPlan(String strdate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
		String plan = planMap.get(date);
		return plan;
	}

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

		// get Weekday automatically
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
		// 1970년 1월 1일은 목요일이다.
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970.01.01: Thursday

		// count로 기준일과 입력한 월의 차일을 구한다.
		int count = 0;
		for (int i = syear; i < year; i++) {
			// 연도는 윤년:366, 일반: 365
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

//	public static void main(String[] args) throws ParseException {
//		Calendar cal = new Calendar();
//		System.out.println(cal.getWeekday(1970, 1, 1));
//		System.out.println(cal.getWeekday(1971, 1, 1));
//		System.out.println(cal.getWeekday(1972, 1, 1));
//		System.out.println(cal.getWeekday(1973, 1, 1));
//		System.out.println(cal.getWeekday(1974, 1, 1));
//		System.out.println(cal.getWeekday(1975, 1, 1));
//
//		cal.registerPlan("2019-12-06", "강의 완강하기");
//		System.out.println(cal.searchPlan("2019-12-06"));
//	}
}
