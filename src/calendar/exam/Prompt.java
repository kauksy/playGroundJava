package calendar.exam;

import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
		// 명령 (1, 2, 3, h, q)
	}

	/**
	 * @param week 요일행
	 * @return 0 ~ 6 (0: Sunday, 6: Saturday)
	 */
	public int parseDay(String week) {
		if (week.equals("SU"))
			return 0;
		if (week.equals("MO"))
			return 1;
		if (week.equals("TU"))
			return 2;
		if (week.equals("WE"))
			return 3;
		if (week.equals("TH"))
			return 4;
		if (week.equals("FR"))
			return 5;
		if (week.equals("SA"))
			return 6;

		return 0;
	}

	public void runPrompt() {
		printMenu();

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scan.next();
			if (cmd.equals("1")) {
				cmdRegister();
			} else if (cmd.equals("2")) {
				cmdSearch();
			} else if (cmd.equals("3")) {
				cmdCalendar(scan, cal);
			} else if (cmd.equals("h")) {
				printMenu();
			} else if (cmd.equals("q")) {
				break;
			}
		}

		System.out.println("Thank you, Bye~");
		scan.close();
	}

	private void cmdCalendar(Scanner scan, Calendar cal) {
		int month = 1;
		int year = 2017;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = scan.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = scan.nextInt();
		if (month > 12 || month < 1) {
			System.out.println("잘못된 월을 입력 했습니다. 년도부터 입력해주세요");
			return; // 메소드를 종료하려먼 리턴하면 됨
		}
		cal.printCalendar(year, month);
	}

	private void cmdSearch() {
		// TODO Auto-generated method stub

	}

	private void cmdRegister() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
