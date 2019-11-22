package calendar;

public class AutoCalendar {
	private static MyCalendar myCalendar = new MyCalendar();
	
	public int sumDays(int thisMonth, int thisYear) {
		int value = 0;
		for (int i = 0; i < thisMonth; i++) {
			if (myCalendar.checkLeapYear(thisYear)) {
				value += MyCalendar.LEAP_MAX_DAYS[i];
			} else {
				value += MyCalendar.BASIC_MAX_DAYS[i];
			}
		}
		return value;
	}

	public int checkDayDistance(int standardYear, int year) {
		// 기준해(올해)보다 이전인지 이후인지
		int inputYear = year;
		int distance;
		
		if(standardYear != year){
			distance = inputYear > standardYear ? inputYear - standardYear + 1 : standardYear - inputYear + 1;
		}else{
			distance = 0;
		}
		System.out.println("distance: " + distance);

		// 1. 윤년/ 평년이 각각 몇 번 있었는지
		int leap = getLeapvalue(standardYear, inputYear);
		int basic = distance - leap;

		// 2. 요일이 얼마나 차이가 나는지
		int dayDistance = (leap * 2) + (basic * 1);
		
		return dayDistance;
	}

	public void answerTodayIs(int sumDays) {
		// 이 값으로 뭘 하기전에 이 해의 1월 1일이 무슨요일인지가 필요.
		System.out.println("이 값으로 뭘 할 수 있찌?");
		System.out.println(sumDays % 7);
	}

	private int getLeapvalue(int standardYear, int inputYear) {
		int standard = totalLeap(standardYear);
		int input = totalLeap(inputYear);
		
		return Math.abs(standard - input);

	}

	private int totalLeap(int year) {
		return (year / 4) - (year / 100) + (year / 400);
	}
	
	public int getRemainDay(int days) {
		return days % 7;

	}
}
