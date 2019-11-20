package calendar.exam;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;

		while (true) {
			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			month = scan.nextInt();

			if (month == -1) {
				break;
			}

			if (month > 12) {
				continue;
			}

			cal.printCalendar(2019, month);
		}
		System.out.println("Bye~");
		scan.close();
	}

	public static void main(String[] args) {

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
