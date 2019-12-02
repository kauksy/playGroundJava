package calendar.exam;

import java.util.Scanner;

public class Prompt {

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
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2017;

		while (true) {
			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scan.nextInt();
			if(year == -1){
				break;
			}

			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			month = scan.nextInt();
			if (month > 12 || month < 1) {
				System.out.println("잘못된 월을 입력 했습니다. 년도부터 입력해주세요");
				continue;
			}

			cal.printCalendar(year, month);
		}
		System.out.println("Bye~");
		scan.close();
	}

	public static void main(String[] args) {

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
