package calendar.exam;

import java.util.Scanner;
import calendar.CalendarFactory;

public class Prompt {

	public static void main(String[] args) {
		String PROMPT = "cal> ";
		Scanner scan = new Scanner(System.in);
		CalendarFactory cal = new CalendarFactory();

		int month = 1;

		while (true) {
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scan.nextInt();

			if (month == -1) {
				break;
			}

			if (month > 12) {
				continue;
			}

			System.out.printf("%d월은 %d일까지 있습니다\n", month, cal.getMaxDaysOfMonth(month));
		}
		System.out.println("Bye~");
		scan.close();
	}

}
