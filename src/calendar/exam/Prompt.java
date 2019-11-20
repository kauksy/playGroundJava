package calendar.exam;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = -1;
		int year = -1;

		while (true) {
			System.out.println("연도를 입력하세요.");
			System.out.print("YEAR> ");
			year = scan.nextInt();
			
			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			month = scan.nextInt();

			if (month == -1) {
				break;
			}

			if (month > 12) {
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
