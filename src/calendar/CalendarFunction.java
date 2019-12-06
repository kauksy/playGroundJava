package calendar;

import java.util.HashMap;
import java.util.Scanner;

public class CalendarFunction {

	private static final int WEEK = 7;
	private static final String SPACE = "   ";
	private HashMap<String, String> plans = new HashMap<>();

	public void registerPlan(Scanner scan) {
		System.out.println("[일정 등록] 날짜를 입력하세요. (yyyy-mm-dd)");
		String dateStr = scan.next();
		scan.nextLine();

		System.out.println("일정을 입력하세요");
		String plan = scan.nextLine();

		plans.put(dateStr, plan);

		System.out.println("일정이 등록 되었습니다.");
	}

	public void searchPlan(Scanner scan) {
		System.out.println("[일정 검색] 날짜를 입력하세요. (yyyy-mm-dd)");
		String dateStr = scan.next();
		scan.nextLine();

		System.out.println(plans.get(dateStr));
	}

	public void viewCalendar(MyCalendar myCalendar, Scanner scan) {
		System.out.println("년도를 입력해주세요.");
		System.out.print("Year> ");
		int year = scan.nextInt();

		System.out.println("월을 입력해주세요.");
		System.out.print("Month> ");
		int month = scan.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 월을 입력하셨습니다.");
			return;
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

}
