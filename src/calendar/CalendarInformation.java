package calendar;

import java.util.Calendar;

public class CalendarInformation {
	
	private AutoCalendar auto = new AutoCalendar();
	private MyCalendar myCalendar = new MyCalendar();
	public static int firstDay;
	
	/**
	 * 시스템상의 오늘을 기준으로 해당 해의 1월 1일의 요일 구하기
	 * 전체 기준이 되는 값이다.
	 * */
	public int getStandardYearInfo() {
		int todayIs = todayIs();
		int thisDay = findThisDay();
		int thisMonth = findThisMonth(todayIs);
		int thisYear = findThisYear();

		int sumDays = auto.sumDays(thisMonth, thisYear) - 1;

		sumDays += thisDay;
		int remainDay = auto.getRemainDay(sumDays);
		firstDay = todayIs - remainDay;

		if (firstDay > 0) {
			return myCalendar.getDay(firstDay);
		} else if (firstDay < 0) {
			return myCalendar.getDay(Math.abs(firstDay) + todayIs);
		}
		return todayIs;
	}
	
	/**
	 * 사용자가 입력한 해의 1월 1일이 무슨요일인지 구하기
	 * */
	public int getInputStandardYearInfo(int inputYear, int standardYoil) {
		int inputStandard;
		// 1. 사용자가 입력한 해와 기준해가 요일이 얼마나 차이 값 저장
		int distance = auto.checkDayDistance(findThisYear(), inputYear);
		
		// 2. 사용자 입력과 기준해 1월 1일의 요일 차이 저장
		inputStandard = auto.getRemainDay(distance);
		
		if(inputYear < findThisYear()){
			inputStandard = (inputStandard * -1) + 7;
		}
		
		int result = auto.getRemainDay(inputStandard + standardYoil);

		return result;
	}

	public int todayIs() {
		Calendar cal = Calendar.getInstance();
		int todayIs = cal.get(Calendar.DAY_OF_WEEK);
//		System.out.println("todayIs: " + todayIs);
		return todayIs;
	}
	
	public int findThisDay() {
		Calendar cal = Calendar.getInstance();
		int thisDay = cal.get(Calendar.DATE);
//		System.out.println("thisDay: " + thisDay);
		return thisDay;
	}

	public int findThisMonth(int todayIs) {
		Calendar cal = Calendar.getInstance();
		int thisMonth = cal.get(Calendar.MONTH);
//		System.out.println("thisMonth: " +  (thisMonth +1 ));
		return thisMonth;

	}
	
	public int findThisYear() {
		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR);
//		System.out.println("thisYear: " + thisYear);
		return thisYear;

	}

	public int getIputFirstDayOfMonth(int month, int year) {
		int beforeDays = auto.sumDays(month, year);
		return auto.getRemainDay(beforeDays);
	}

	public int getYoil(int inputStandardYoil, int inputDistance) {
		return (inputStandardYoil + inputDistance) % 7;
	}


}
