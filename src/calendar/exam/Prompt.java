package calendar.exam;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	/**
	 * @param week
	 *            요일행
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

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scan.next();
			if (cmd.equals("1")) {
				cmdRegister(scan, cal);
			} else if (cmd.equals("2")) {
				cmdSearch(scan, cal);
			} else if (cmd.equals("3")) {
				cmdCalendar(scan, cal);
			} else if (cmd.equals("h")) {
				printMenu();
			} else if (cmd.equals("q")) {
				break;
			} else {
				System.out.println("잘못된 입력을 하셨습니다. 프로그램을 종료합니다.");
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

	private void cmdSearch(Scanner scan, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요. (yyyy-mm-dd)");
		String date = scan.next();
		String plan = "";
		try {
			plan = cal.searchPlan(date);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner scan, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요. (yyyy-mm-dd)");
		String date = scan.next();
		String text = "";
		scan.nextLine();
		System.out.println("일정을 입력해주세요.");
		text = scan.nextLine();
		cal.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
