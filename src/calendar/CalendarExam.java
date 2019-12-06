package calendar;

import java.util.Scanner;

public class CalendarExam {

	private static Scanner scan = new Scanner(System.in);
	private static MyCalendar myCalendar = new MyCalendar();

	private static void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public static void main(String[] args) {
		CalendarFunction calFunction = new CalendarFunction();
		int year = 2019;
		int month = 1;

		printMenu();
		String answer = " ";
		while (!answer.equals("q")) {
			System.out.println("명령 (1, 2, 3, h, q)");
			answer = scan.next();
			switch (answer) {
			case "1":
				// 일정등록
				calFunction.registerPlan(scan);
				break;
			case "2":
				// 일정 검색
				calFunction.searchPlan(scan);
				break;
			case "3":
				// 달력보기
				calFunction.viewCalendar(myCalendar, scan);
				break;
			case "h":
				// 도움말
				printMenu();
				break;
			case "q":
				// 종료
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
