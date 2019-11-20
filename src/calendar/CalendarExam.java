package calendar;

import java.util.Scanner;

public class CalendarExam {

	private static Scanner scan = new Scanner(System.in);
	private static MyCalendar myCalendar = new MyCalendar();

	public static void main(String[] args) {

		int year = -1;
		int month = -1;

		while (true) {
			System.out.println("년도를 입력해주세요.");
			System.out.print("Year> ");
			year = scan.nextInt();
			System.out.println("월을 입력해주세요.");
			System.out.print("Month> ");
			month = scan.nextInt();

			if (year == -1 || month == -1) {
				break;
			}

			int maxDay = myCalendar.getMonthOfMaxDays(year, month);
			myCalendar.calendarFrame(year, month);
			
			for(int i = 1; i <= maxDay; i++){
				System.out.printf("%3d", i);
				if(i%7 ==0){
					System.out.printf("\n");
				}
			}
			System.out.println();
		}
		System.out.println();

	}

}
