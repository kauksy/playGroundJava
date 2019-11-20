package calendar;

import java.util.Scanner;

public class CalendarFactory {
	public static String PROMPT = "cal> ";
	public static final int[] maxMonthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static Scanner scan = new Scanner(System.in);
	Calendar cal = new Calendar();

	public static int getMaxDaysOfMonth(int month) {
		return maxMonthDays[month - 1];
	}

	public static void print_28Calendar() {
		System.out.println("일     월     화     수     목    금     토");
		System.out.println("---------------------------");
		System.out.println(" 1   2   3   4   5   6   7");
		System.out.println(" 8   9  10  11  12  13  14");
		System.out.println("15  16  17  18  19  20  21");
		System.out.println("22  23  24  25  26  27  28");
	}
	
	public static void print_30Calendar() {
		System.out.println("일     월     화     수     목    금     토");
		System.out.println("---------------------------");
		System.out.println(" 1   2   3   4   5   6   7");
		System.out.println(" 8   9  10  11  12  13  14");
		System.out.println("15  16  17  18  19  20  21");
		System.out.println("22  23  24  25  26  27  28");
		System.out.println("29  30");
	}
	
	public static void print_31Calendar() {
		System.out.println("일     월     화     수     목    금     토");
		System.out.println("---------------------------");
		System.out.println(" 1   2   3   4   5   6   7");
		System.out.println(" 8   9  10  11  12  13  14");
		System.out.println("15  16  17  18  19  20  21");
		System.out.println("22  23  24  25  26  27  28");
		System.out.println("29  30  31");
	}

	public static void inputCalendar() {
		System.out.println("달을 입력하세요.");
		int month = scan.nextInt();

		System.out.printf("%d월은 %d일까지 있습니다. \n", month, getMaxDaysOfMonth(month));
	}

	public static void cycleCalendar() {
		System.out.println("반복횟수를 입력하세요.");
		int cycle = scan.nextInt();
		int[] months = new int[cycle];
		System.out.println("월을 입력하세요.");

		for (int i = 0; i < cycle; i++) {
			months[i] = scan.nextInt();
		}

		for (int i = 0; i < cycle; i++) {
			System.out.printf("%d월은 %d일까지 있습니다. \n", months[i], getMaxDaysOfMonth(months[i]));
		}
	}

	public static void exitCondition() {
		int month;
		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scan.nextInt();
			
			if(month == -1 ){
				break; // 루프 빠져나가기
			}
			
			if(month > 12){
				continue; // 루프의 처음으로 돌아가서, 다시 로프 돌기
			}
			
			System.out.printf("%d월은 %d일까지 있습니다. \n", month, getMaxDaysOfMonth(month));
		}
		System.out.println("Bye~! Have a nice day!");
	}

}
